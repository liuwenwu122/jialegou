package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.service.impl.BaseServiceImpl;
import com.pinyougou.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl extends BaseServiceImpl<TbBrand> implements BrandService {

    @Autowired
    private BrandMapper brandMapper;


    @Override
    public List<TbBrand> queryAll() {
        return brandMapper.queryAll();
    }


    @Override
    public List<TbBrand> testPage(Integer pageNum, Integer rows) {
        //        使用分页助手
        PageHelper.startPage(pageNum, rows);
        return brandMapper.selectAll();
    }

    @Override
    public PageResult brandSearch(Integer pageNum, Integer rows, TbBrand brand) {

//        分页助手查询
        PageHelper.startPage(pageNum, rows);

//        创建 Example 例子
        Example example = new Example(TbBrand.class);
//        创建查询条件
        Example.Criteria criteria = example.createCriteria();
//        判断搜索条件不为空,并不包含空字符串
        if (!StringUtils.isEmpty(brand.getFirstChar())) {
            criteria.andEqualTo("firstChar", brand.getFirstChar());
        }
        if (!StringUtils.isEmpty(brand.getName())) {
            criteria.andLike("name", "%"+ brand.getName() + "%");
        }
        List<TbBrand> list = brandMapper.selectByExample(example);
        PageInfo<TbBrand> pageInfo = new PageInfo<>(list);

        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }
}

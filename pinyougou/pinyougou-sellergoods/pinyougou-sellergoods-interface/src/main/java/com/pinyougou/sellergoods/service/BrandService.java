package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.service.BaseService;
import com.pinyougou.vo.PageResult;

import java.util.List;

public interface BrandService extends BaseService<TbBrand> {

    /**
     * 查询所有商品列表
     * @return List<TbBrand>
     */
    List<TbBrand> queryAll();


    /**
     *  分页测试
     * @param pageNum
     * @param rows
     * @return List<TbBrand>
     */
   List<TbBrand> testPage(Integer pageNum, Integer rows);


    /**
     * 分页搜索
     * @param pageNum
     * @param rows
     * @param brand
     */
    PageResult brandSearch(Integer pageNum, Integer rows, TbBrand brand);
}

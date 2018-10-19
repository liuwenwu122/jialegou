package com.pinyougou.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.vo.PageResult;
import com.pinyougou.vo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/brand")
@RestController
public class BrandController {

    @Reference
    private BrandService brandService;

    @PostMapping("/search")
    public PageResult search(@RequestBody TbBrand brand,
                             @RequestParam(value ="page",defaultValue ="1") Integer pageNum,
                             @RequestParam(value ="rows",defaultValue = "5") Integer rows){

       return brandService.brandSearch(pageNum,rows,brand);
    }

    @GetMapping("/delete")
    public Result delete(Long[] ids){

        try {
            brandService.deleteByIds(ids);
            return Result.ok("删除品牌列表成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("删除品牌列表失败");
        }
    }


    @PostMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try {
            brandService.update(brand);
            return Result.ok("更新品牌成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("更新产品失败");
        }
    }


    @GetMapping("/findOne")
    public TbBrand findOne(Long id){
       return brandService.findOne(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
           return Result.ok("添加品牌成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("添加产品失败");
        }
    }

    @GetMapping("/findAll")
    public List<TbBrand> findAll(){

       return brandService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult findPage(@RequestParam(value = "page",defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "rows",defaultValue = "5" ) Integer rows){

        return  brandService.findPage(pageNum,rows);
    }

}

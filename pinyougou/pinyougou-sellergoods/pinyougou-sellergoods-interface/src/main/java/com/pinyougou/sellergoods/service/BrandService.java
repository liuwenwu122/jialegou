package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有商品列表
     * @return List<TbBrand>
     */
    List<TbBrand> queryAll();
}

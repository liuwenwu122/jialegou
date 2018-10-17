package com.pinyougou.mapper;

import com.pinyougou.pojo.TbBrand;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有商品列表
     * @return List<TbBrand>
     */
    List<TbBrand> queryAll();
}

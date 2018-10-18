package com.pinyougou.service;

import com.pinyougou.vo.PageResult;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {

    /**
     * 根据主键查询
     * @return List<TbBrand>
     */
    public T findOne(Serializable id);


    /**
     * 查询全部
     * @return List<TbBrand>
     */
    public List<T> findAll();


    /**
     * 根据条件查询
     *
     * @param t
     * @return List<TbBrand>
     */
    public List<T> findByWhere(T t);

    /**
     * 分页查询
     *
     * @param pageNum 页号
     * @param rows  页大小
     * @return List<TbBrand>
     */
    public PageResult findPage(Integer pageNum, Integer rows);


    /**
     * 分页根据条件查询
     *
     * @param pageNum 页号
     * @param rows 页大小
     * @param t 查询条件
     * @return List<TbBrand>
     */
    public PageResult findPage(Integer pageNum, Integer rows, T t);


    /**
     * 添加
     *
     * @param t
     */
    public void add(T t);


    /**
     * 更新
     * @param t
     */
    public void update(T t);


    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(Serializable[] ids);
}

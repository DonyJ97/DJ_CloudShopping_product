package com.imooc.product.service;

import com.imooc.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:25 2020/1/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

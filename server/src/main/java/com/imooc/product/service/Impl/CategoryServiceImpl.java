package com.imooc.product.service.Impl;

import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.repository.ProductCategoryRepository;
import com.imooc.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:27 2020/1/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}

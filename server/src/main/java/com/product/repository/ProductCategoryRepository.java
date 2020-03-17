package com.product.repository;

import com.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 16:19 2020/1/2
 * @ Description：商户类目接口
 * @ Modified By：
 * @Version: $
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

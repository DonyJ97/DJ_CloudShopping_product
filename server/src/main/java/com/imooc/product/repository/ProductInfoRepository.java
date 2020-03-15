package com.imooc.product.repository;

import com.imooc.product.dataobject.Product_info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 15:30 2020/1/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface ProductInfoRepository extends JpaRepository<Product_info,String> {
    List<Product_info> findByProductStatus(Integer productStatus);
    List<Product_info> findByProductIdIn(List<String> productIdList);
}

package com.product.service;

import com.product.dto.CartDTO;
import com.product.dataobject.Product_info;

import java.util.List;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:05 2020/1/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface ProductService {
    /*
    * 查询所有在架商品列表
    * */
    List<Product_info> findUpAll();
    /*
     * 查询商品列表
     * */
    List<Product_info> findAll(List<String> productIdList);
    /*
     * 扣库存
     * */
    void decreaseStock(List<CartDTO> cartDTOList);
}

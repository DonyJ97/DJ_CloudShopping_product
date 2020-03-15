package com.imooc.product.dto;

import lombok.Data;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 14:23 2020/1/16
 * @ Description：购物车类，作为扣库存时的传入参数
 * @ Modified By：
 * @Version: $
 */
@Data
public class CartDTO {
    //商品ID
    private String productId;
    //商品数量
    private Integer productQuantity;

    public CartDTO(String id, Integer productQuantity){
        this.productId = id;
        this.productQuantity = productQuantity;
    }
}

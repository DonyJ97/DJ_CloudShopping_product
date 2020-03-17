package com.product.enums;

import lombok.Getter;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:15 2020/1/2
 * @ Description：商品上架下架状态
 * @ Modified By：
 * @Version: $
 */
@Getter
public enum  ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架"),
    ;
    private Integer code;
    private String message;


    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

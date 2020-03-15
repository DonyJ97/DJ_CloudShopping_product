package com.imooc.product.enums;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 14:35 2020/1/16
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Getter
public enum  ResultEnum {
    PRODUCT_NOT_EXIST(1,"商品不存在"),
    PRODUCT_STOCK_ERROR(2,"库存有误")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

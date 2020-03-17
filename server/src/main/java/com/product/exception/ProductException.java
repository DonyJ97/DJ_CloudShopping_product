package com.product.exception;

import com.product.enums.ResultEnum;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 14:33 2020/1/16
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class ProductException extends RuntimeException{
    private Integer code;

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}

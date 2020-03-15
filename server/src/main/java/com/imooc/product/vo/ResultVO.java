package com.imooc.product.vo;

import lombok.Data;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:35 2020/1/2
 * @ Description：http请求返回的最外层对象
 * @ Modified By：
 * @Version: $
 */
@Data
public class ResultVO<T> {
    /*
    *   错误码正常返回为0
    * */
    private Integer code;
    /*
     *   提示信息
     * */
    private String msg;
    /*
     *   具体内容
     * */
    private T data;
}

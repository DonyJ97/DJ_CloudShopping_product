package com.imooc.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 10:25 2020/1/9
 * @ Description：订单服务调用商品服务时，product作为server，order作为client
 * @ Modified By：
 * @Version: $
 */
@RestController
public class ServerController {
    @GetMapping("/msg")
    public String msg(){
        return "this is a product msg";
    }
}

package com.imooc.product.service.Impl;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.dataobject.Product_info;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:18 2020/1/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest{
    @Autowired
    private ProductServiceImpl productService;
    @Test
    void findUpAll() throws Exception{
        List<Product_info> list = productService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }
    @Test
    void decreaseStock() throws Exception{
        CartDTO cartDTO = new CartDTO("157811321161313248",100);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }
}

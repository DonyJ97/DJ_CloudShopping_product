package com.imooc.product.service.Impl;

import com.imooc.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:30 2020/1/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    void findByCategoryTypeIn() throws Exception{
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(list.size()>0);
    }
}

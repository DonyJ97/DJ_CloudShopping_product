package com.imooc.product.repository;

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
 * @ Date       ：Created in 17:57 2020/1/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryRepositoryTest {
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> list = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(list.size()>0);
    }
}

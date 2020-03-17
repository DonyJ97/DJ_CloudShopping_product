package com.product.repository;

import com.product.dataobject.Product_info;
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
 * @ Date       ：Created in 15:34 2020/1/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Test
    public void findByProductStatus() throws Exception{
        List<Product_info> list = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(list.size()>0);
    }
    @Test
    public void findByProductIdIn() throws Exception{
        List<Product_info> list = productInfoRepository.findByProductIdIn(Arrays.asList("157811321161313248","157875196133315158"));
        Assert.assertTrue(list.size()>0);
    }
}


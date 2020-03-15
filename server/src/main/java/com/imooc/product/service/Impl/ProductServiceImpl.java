package com.imooc.product.service.Impl;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.dataobject.Product_info;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.ProductService;
import com.imooc.product.utils.JsonUtil;
import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.aop.framework.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:11 2020/1/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Override
    public List<Product_info> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
    @Override
    public List<Product_info> findAll(List<String> productIdList){
        return productInfoRepository.findByProductIdIn(productIdList);
    }
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList){
        for(CartDTO cartDTO : cartDTOList){
            Optional<Product_info> product_infoOptional = productInfoRepository.findById(cartDTO.getProductId());
            //判断商品是否存在
            if(!product_infoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Product_info product_info = product_infoOptional.get();
            Integer result = product_info.getProductStock() - cartDTO.getProductQuantity();
            //判断商品库存是否满足要求
            if(result < 0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            product_info.setProductStock(result);
            productInfoRepository.save(product_info);
            //发送MQ消息
            amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(product_info));
        }
    }

}

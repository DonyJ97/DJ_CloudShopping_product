package com.product.service.Impl;

import com.product.dto.CartDTO;
import com.product.dataobject.Product_info;
import com.product.enums.ProductStatusEnum;
import com.product.enums.ResultEnum;
import com.product.exception.ProductException;
import com.product.repository.ProductInfoRepository;
import com.product.service.ProductService;
import com.product.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

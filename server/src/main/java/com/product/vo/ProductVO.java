package com.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:37 2020/1/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Data
public class ProductVO {
    @JsonProperty("name")
    private String CategoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;
}

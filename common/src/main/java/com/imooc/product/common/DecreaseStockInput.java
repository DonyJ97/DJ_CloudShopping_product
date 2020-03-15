package com.imooc.product.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 11:48 2020/1/20
 * @ Description：减库存
 * @ Modified By：
 * @Version: $
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecreaseStockInput {
    private String productId;
    private Integer productQuantity;
}

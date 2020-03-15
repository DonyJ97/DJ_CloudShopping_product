package com.imooc.product.common;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 11:42 2020/1/20
 * @ Description：不能对外暴露数据库实体类，所以要包装一下
 * @ Modified By：
 * @Version: $
 */
@Data
public class ProductInfoOutput {
    private String productId;
    /**  名字 **/
    private String productName;
    /**  单价 **/
    private BigDecimal productPrice;
    /**  库存 **/
    private Integer productStock;
    /**  描述 **/
    private String productDescription;
    /**  小图 **/
    private String productIcon;
    /**  状态 ， 0正常1下架**/
    private Integer productStatus;
    /**  类目编号 **/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}

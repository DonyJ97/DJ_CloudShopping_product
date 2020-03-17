package com.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 16:13 2020/1/2
 * @ Description：商品类目
 * @ Modified By：
 * @Version: $
 */
@Data
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 商品类目名 **/
    private String categoryName;
    /** 商品类目编号 **/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}

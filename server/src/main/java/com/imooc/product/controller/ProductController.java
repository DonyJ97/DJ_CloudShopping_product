package com.imooc.product.controller;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.dataobject.Product_info;
import com.imooc.product.service.CategoryService;
import com.imooc.product.service.ProductService;
import com.imooc.product.utils.ResultVOUtil;
import com.imooc.product.vo.ProductInfoVO;
import com.imooc.product.vo.ProductVO;
import com.imooc.product.vo.ResultVO;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 15:05 2020/1/2
 * @ Description：商品
 * @ Modified By：
 * @Version: $
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    /*
    * 1.查询所有在架商品
    * 2.获取类目type列表
    * 3.查询类目
    * 4.构造数据
    * */
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        //1.查询所有在架商品
        List<Product_info> productInfoList= productService.findUpAll();

        //2.获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
               .map(Product_info::getCategoryType)
               .collect(Collectors.toList());

        //3.从数据库查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //4.构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : categoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            //遍历商品数据
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(Product_info product_info : productInfoList){
                if (product_info.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(product_info,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }

            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

    //Feign，order调用product服务，提供商品ID列表，返回商品信息列表
    @PostMapping("/listForOrder")
    public List<Product_info> listForOrder (@RequestBody  List<String> productIdList){

        return productService.findAll(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
        productService.decreaseStock(cartDTOList);
    }
}

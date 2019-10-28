package cn.kgc.controller;

import cn.kgc.domain.Product;
import cn.kgc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("getProduct")
    @ResponseBody
    public List<Product> getProduct(){
        List<Product> products = productService.selectAllProduct();
        return products;
    }

    @RequestMapping("checkNum")
    @ResponseBody
    public Map<String,Object> checkNum(String id){
        int i = productService.selectNumById(id);
        Map<String,Object> map=new HashMap<>();
        map.put("result",i);
        return map;
    }
}

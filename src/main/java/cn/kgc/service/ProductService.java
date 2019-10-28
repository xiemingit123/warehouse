package cn.kgc.service;

import cn.kgc.domain.Product;

import java.util.List;

public interface ProductService {

    //查询商品
    List<Product> selectAllProduct();

    //根据id查询库存量
    int selectNumById(String id);
}

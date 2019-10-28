package cn.kgc.service.impl;

import cn.kgc.dao.ProductMapper;
import cn.kgc.domain.Product;
import cn.kgc.domain.ProductExample;
import cn.kgc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> selectAllProduct() {
        return productMapper.selectByExample(new ProductExample());
    }

    @Override
    public int selectNumById(String id) {
        return productMapper.selectNumById(id);
    }
}

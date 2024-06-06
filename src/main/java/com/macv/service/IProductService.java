package com.macv.service;

import com.macv.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    ProductEntity create(ProductEntity productEntity);
    void deleteById(Long id);
    List<ProductEntity> getAll();
    ProductEntity findById(Long id);
}

package com.macv.service;

import com.macv.entity.ProductEntity;
import com.macv.exception.ElementNotFoundCustomException;
import com.macv.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProductServiceImpl implements IProductService{
    private final ProductRepository productRepository;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity create(ProductEntity productEntity) {
        productRepository.persist(productEntity);
        return productEntity;
    }

    @Override
    public void deleteById(Long id) {
        ProductEntity product = this.findById(id);
        productRepository.delete(product);
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.listAll();
    }

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findByIdOptional(id)
                .orElseThrow(
                        () -> new ElementNotFoundCustomException("Product not found")
                );
    }
}

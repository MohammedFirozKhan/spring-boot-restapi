package com.hcl.dna.hackathon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dna.hackathon.exception.ProductNotFoundException;
import com.hcl.dna.hackathon.model.Product;
import com.hcl.dna.hackathon.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository productRepository;

  @Override
  public Iterable<Product> retrieveAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product retrieveProduct(long id) {
    Optional<Product> product = productRepository.findById(id);

    if (!product.isPresent()) throw new ProductNotFoundException("id-" + id);

    return product.get();
  }

  @Override
  public void deleteProduct(long id) {
    productRepository.deleteById(id);
  }

  @Override
  public Product createProduct(Product product) {
    Product savedProduct = productRepository.save(product);
    return savedProduct;
  }

  @Override
  public void updateProduct(Product product, long id) {
    Optional<Product> productOptional = productRepository.findById(id);

    if (!productOptional.isPresent()) throw new ProductNotFoundException("id-" + id);

    product.setId(id);

    productRepository.save(product);
  }
}

package com.hcl.dna.hackathon.service;

import com.hcl.dna.hackathon.model.Product;

public interface ProductService {

  public Iterable<Product> retrieveAllProducts();

  public Product retrieveProduct(long id);

  public void deleteProduct(long id);

  public Product createProduct(Product product);

  public void updateProduct(Product product, long id);
}

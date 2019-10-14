package com.hcl.dna.hackathon.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hcl.dna.hackathon.model.Product;
import com.hcl.dna.hackathon.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

  @Autowired private ProductService productService;

  @GetMapping("/products")
  public List<Product> retrieveAllProducts() {
    return (List<Product>) productService.retrieveAllProducts();
  }

  @GetMapping("/products/{id}")
  public Product retrieveProduct(@PathVariable long id) {
    return productService.retrieveProduct(id);
  }

  @DeleteMapping("/products/{id}")
  public void deleteProduct(@PathVariable long id) {
    productService.deleteProduct(id);
  }

  @PostMapping("/products")
  public ResponseEntity<Object> createProduct(@Valid @RequestBody Product product) {
    Product savedProduct = productService.createProduct(product);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedProduct.getId())
            .toUri();

    return ResponseEntity.created(location).build();
  }

  @PutMapping("products/{id}")
  public ResponseEntity<Object> updateProduct(@Valid @RequestBody Product product, @PathVariable long id) {

    productService.updateProduct(product, id);

    return ResponseEntity.noContent().build();
  }
}

package com.hcl.dna.hackathon.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Product title is required.")
  @Basic(optional = false)
  private String title;

  private Double price;
  private String brand;
  private String pictureUrl;

  public Product() {}

  public Product(
      Long id,
      @NotNull(message = "Product title is required.") String title,
      String brand,
      Double price,
      String pictureUrl
      ) {
	  
    super();
    this.id = id;
    this.title = title;
    this.brand = brand;
    this.price = price;
    this.pictureUrl = pictureUrl;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getPictureUrl() {
    return pictureUrl;
  }

  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
  }
}

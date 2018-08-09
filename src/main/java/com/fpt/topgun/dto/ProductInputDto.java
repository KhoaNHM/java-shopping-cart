package com.fpt.topgun.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductInputDto {
  
  @NotNull
  private int idCategory;

  @NotNull
  @Size(min=2, max=200, message="name should have atleast 2 characters and max is 200")
  private String name;

  @NotNull
  @Size(min=2, max=200, message="description should have atleast 2 characters and max is 200")
  private String description;

  @NotNull
  @Min(value = 1, message = "quantity should be equal or more than 1")
  private int quantity;

  @NotNull
  @Min(value = 1, message = "price should be equal or more than 1")
  private double price;
  
  private int image_id;
  
  private String image_Name;
  
  

  /**
   * @return the image_id
   */
  public int getImage_id() {
    return image_id;
  }

  /**
   * @param image_id the image_id to set
   */
  public void setImage_id(int image_id) {
    this.image_id = image_id;
  }

  /**
   * @return the image_Name
   */
  public String getImage_Name() {
    return image_Name;
  }

  /**
   * @param image_Name the image_Name to set
   */
  public void setImage_Name(String image_Name) {
    this.image_Name = image_Name;
  }

  /**
   * @return the idCategory
   */
  public int getIdCategory() {
    return idCategory;
  }

  /**
   * @param idCategory the idCategory to set
   */
  public void setIdCategory(int idCategory) {
    this.idCategory = idCategory;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * @param quantity the quantity to set
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * @return the price
   */
  public double getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(double price) {
    this.price = price;
  }

  
}

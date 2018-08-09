package com.fpt.topgun.dto;

import java.util.Date;

public class ProductOutputDto {
 
  private int idCategory;
  
  private int idProduct;

  private CategoryOutputDto category;

  private String name;

  private String description;

  private int quantity;

  private double price;

  private Date created_date;
  
  private int image_id;
  
  private String image_Name;
  
  /**
   * @return the category
   */
  public CategoryOutputDto getCategory() {
    return category;
  }

  /**
   * @param category the category to set
   */
  public void setCategory(CategoryOutputDto category) {
    this.category = category;
  }

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
   * @return the idProduct
   */
  public int getIdProduct() {
    return idProduct;
  }

  /**
   * @param idProduct the idProduct to set
   */
  public void setIdProduct(int idProduct) {
    this.idProduct = idProduct;
  }

  /**
   * @return the category
   */
  public CategoryOutputDto getCategoryDto() {
    return category;
  }

  /**
   * @param category the category to set
   */
  public void setCategoryDto(CategoryOutputDto category) {
    this.category = category;
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

  /**
   * @return the created_date
   */
  public Date getCreated_date() {
    return created_date;
  }

  /**
   * @param created_date the created_date to set
   */
  public void setCreated_date(Date created_date) {
    this.created_date = created_date;
  }

}

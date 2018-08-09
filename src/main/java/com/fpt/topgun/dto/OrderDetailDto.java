package com.fpt.topgun.dto;

public class OrderDetailDto {

  private int id;

  private OrderDto orderDto;

  private int price;

  private double amount;

  private ProductOutputDto productDto;

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the orderDto
   */
  public OrderDto getOrderDto() {
    return orderDto;
  }

  /**
   * @param orderDto the orderDto to set
   */
  public void setOrderDto(OrderDto orderDto) {
    this.orderDto = orderDto;
  }

  /**
   * @return the price
   */
  public int getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   * @return the amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * @return the productDto
   */
  public ProductOutputDto getProductDto() {
    return productDto;
  }

  /**
   * @param productDto the productDto to set
   */
  public void setProductDto(ProductOutputDto productDto) {
    this.productDto = productDto;
  }
}

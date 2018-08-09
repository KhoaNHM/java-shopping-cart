package com.fpt.topgun.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderInputDto {
  
  @NotNull
  private List<Items> items;
  
  @NotNull
  @Size(min=2, max=200, message="orderAddress should have atleast 2 characters and max is 200")
  private String orderAddress;
  
  @NotNull
  @Size(min=2, max=200, message="orderEmail should have atleast 2 characters and max is 200")
  private String orderEmail;
  
  @NotNull
  @Size(min=2, max=200, message="orderName should have atleast 2 characters and max is 200")
  private String orderName;
  
  @NotNull
  @Size(min=2, max=200, message="orderPhone should have atleast 2 characters and max is 200")
  private String orderPhone;

  /**
   * @return the items
   */
  public List<Items> getItems() {
    return items;
  }

  /**
   * @param items
   *          the items to set
   */
  public void setItems(List<Items> items) {
    this.items = items;
  }

  /**
   * @return the orderAddress
   */
  public String getOrderAddress() {
    return orderAddress;
  }

  /**
   * @param orderAddress
   *          the orderAddress to set
   */
  public void setOrderAddress(String orderAddress) {
    this.orderAddress = orderAddress;
  }

  /**
   * @return the orderEmail
   */
  public String getOrderEmail() {
    return orderEmail;
  }

  /**
   * @param orderEmail
   *          the orderEmail to set
   */
  public void setOrderEmail(String orderEmail) {
    this.orderEmail = orderEmail;
  }

  /**
   * @return the orderName
   */
  public String getOrderName() {
    return orderName;
  }

  /**
   * @param orderName
   *          the orderName to set
   */
  public void setOrderName(String orderName) {
    this.orderName = orderName;
  }

  /**
   * @return the orderPhone
   */
  public String getOrderPhone() {
    return orderPhone;
  }

  /**
   * @param orderPhone
   *          the orderPhone to set
   */
  public void setOrderPhone(String orderPhone) {
    this.orderPhone = orderPhone;
  }

}

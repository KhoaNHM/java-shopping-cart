package com.fpt.topgun.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fpt.topgun.entity.OrderDetail;

public class OrderDto {
  @NotNull
  private int idorder;
  
  @NotNull
  private double amount;

  @NotNull
  private String orderAddress;

  @NotNull
  private String orderEmail;

  @NotNull
  private String orderName;

  @NotNull
  private String orderPhone;

  private List<OrderDetail> orderDetail;

  /**
   * @return the idorder
   */
  public int getIdorder() {
    return idorder;
  }

  /**
   * @param idorder the idorder to set
   */
  public void setIdorder(int idorder) {
    this.idorder = idorder;
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
   * @return the orderAddress
   */
  public String getOrderAddress() {
    return orderAddress;
  }

  /**
   * @param orderAddress the orderAddress to set
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
   * @param orderEmail the orderEmail to set
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
   * @param orderName the orderName to set
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
   * @param orderPhone the orderPhone to set
   */
  public void setOrderPhone(String orderPhone) {
    this.orderPhone = orderPhone;
  }

  /**
   * @return the orderDetail
   */
  public List<OrderDetail> getOrderDetail() {
    return orderDetail;
  }

  /**
   * @param orderDetail the orderDetail to set
   */
  public void setOrderDetail(List<OrderDetail> orderDetail) {
    this.orderDetail = orderDetail;
  }

}

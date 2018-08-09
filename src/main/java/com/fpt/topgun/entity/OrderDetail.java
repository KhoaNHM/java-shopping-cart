package com.fpt.topgun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "table_order_detail")
public class OrderDetail {
  
  private int idorder;

  private int idProduct;
  
  @Id
  @Column(name = "iorder_detail", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idorder", nullable = false, insertable = false, updatable = false)
  @JsonIgnore
  private Order order;

  @Column(name = "price", nullable = false)
  private int price;

  @Column(name = "amount", nullable = false)
  private double amount;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idProduct", nullable = false, insertable = false, updatable = false)
  @JsonIgnore
  private Product product;

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
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the order
   */
  public Order getOrder() {
    return order;
  }

  /**
   * @param order the order to set
   */
  public void setOrder(Order order) {
    this.order = order;
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
   * @return the product
   */
  public Product getProduct() {
    return product;
  }

  /**
   * @param product the product to set
   */
  public void setProduct(Product product) {
    this.product = product;
  }

  
}

package com.fpt.topgun.dto;

import javax.validation.constraints.NotNull;

public class Items {

   @NotNull
  private int idProduct;
  
   @NotNull
  private int quantity;

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


}

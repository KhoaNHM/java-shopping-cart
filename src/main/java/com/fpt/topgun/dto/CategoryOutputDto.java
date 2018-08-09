package com.fpt.topgun.dto;

import javax.validation.constraints.NotNull;

public class CategoryOutputDto {
  @NotNull
  private int id;
  @NotNull
  private String name;
  @NotNull
  private String description;


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
  
  
}

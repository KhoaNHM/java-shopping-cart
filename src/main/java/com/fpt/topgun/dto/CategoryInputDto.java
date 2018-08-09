package com.fpt.topgun.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryInputDto {

  @NotNull
  @Size(min=2, max=200, message="name should have atleast 2 characters and max is 200")
  private String name;
  
  @NotNull
  @Size(min=2, max=200, message="description should have atleast 2 characters and max is 200")
  private String description;

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name
   *          the name to set
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
   * @param description
   *          the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

}

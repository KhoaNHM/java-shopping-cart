package com.fpt.topgun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_user")
public class User {
  @Id
  @Column(name = "id_user", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id_user;

  @Column(name = "user_name", nullable = false)
  private String user_name;
  
  @Column(name = "password", nullable = false)
  private String password;

  /**
   * @return the id_user
   */
  public int getId_user() {
    return id_user;
  }

  /**
   * @param id_user
   *          the id_user to set
   */
  public void setId_user(int id_user) {
    this.id_user = id_user;
  }

  /**
   * @return the user_name
   */
  public String getUser_name() {
    return user_name;
  }

  /**
   * @param user_name the user_name to set
   */
  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

 

}

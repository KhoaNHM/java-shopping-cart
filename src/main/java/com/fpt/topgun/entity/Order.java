package com.fpt.topgun.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "table_order")
public class Order {
	@Id
	@Column(name = "idorder", length = 50, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idorder;

	@Column(name = "created_time", nullable = false)
	
	private Date created_time;

	@Column(name = "amount", nullable = false)
	@NotNull
  @Min(value = 1, message = "amount should be equal or more than 1")
	private double amount;

	@Column(name = "order_address", nullable = false, length = 255)
	@NotNull
  @Size(min=7, max=254, message="orderAddress should have atleast 7 characters and max is 254")
	private String orderAddress;

	@Column(name = "order_email", nullable = false, length = 100)
	@NotNull
  @Size(min=7, max=99, message="orderEmail should have atleast 7 characters and max is 99")
//	@Email
	private String orderEmail;

	@Column(name = "order_name", nullable = false, length = 100)
	@NotNull
  @Size(min=2, max=254, message="orderName should have atleast 2 characters and max is 254")
	private String orderName;

	@Column(name = "order_phone", nullable = false, length = 50)
	@NotNull
  @Size(min=2, max=49, message="orderPhone should have atleast 2 characters and max is 49")
	private String orderPhone;

	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderDetail> orderDetail;
	@Column(name = "userID")
	private int userID;
	/**
	 * @return the orderDetail
	 */
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	/**
	 * @param orderDetail
	 *            the orderDetail to set
	 */
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	/**
	 * 
	 */
	public Order() {
		super();
	}

	/**
   * @return the userID
   */
  public int getUserID() {
    return userID;
  }

  /**
   * @param userID the userID to set
   */
  public void setUserID(int userID) {
    this.userID = userID;
  }

  /**
	 * @return the idorder
	 */
	public int getIdorder() {
		return idorder;
	}

	/**
	 * @param idorder
	 *            the idorder to set
	 */
	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}

	/**
	 * @return the created_time
	 */
	public Date getCreated_time() {
		return created_time;
	}

	/**
	 * @param created_time
	 *            the created_time to set
	 */
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
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
	 * @param orderAddress
	 *            the orderAddress to set
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
	 *            the orderEmail to set
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
	 *            the orderName to set
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
	 *            the orderPhone to set
	 */
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

}

package com.fpt.topgun.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "table_product")
public class Product {
  private int idCategory;
	@Id
	@Column(name = "idproduct", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProduct;
	
	@ManyToOne
	@JoinColumn(name = "idCategory", nullable = false,insertable = false,updatable =false)
	@JsonIgnore
	private Category category;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderDetail> orderDetail;

	@Column(name = "name", length = 200, nullable = false)
	@Size(min=2, max=200, message="name should have atleast 2 characters and max is 200")
	private String name;

	@Column(name = "description", nullable = true)
	@Size(min=2, max=200, message="description should have atleast 2 characters and max is 200")
	private String description;

	@Column(name = "quantity", nullable = false)
	@NotNull
  @Min(value = 1, message = "quantity should be equal or more than 1")
	private int quantity;

	@Column(name = "price", nullable = false)
  @NotNull
  @Min(value = 1, message = "price should be equal or more than 1")
	private double price;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	private Date created_date;
	
	@Column(name ="image_id", nullable = false)
	private int image_id;
	
	@Column(name ="image_name", nullable = false)
  private String image_Name;
	
	@Column(name ="most_buy", nullable = false)
	private int mostBuy;
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
	 * 
	 */
	public Product() {
		super();
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
	 * @return the oderDetail
	 */
	public List<OrderDetail> getOderDetail() {
		return orderDetail;
	}

	/**
	 * @param oderDetail
	 *            the oderDetail to set
	 */
	public void setOderDetail(List<OrderDetail> oderDetail) {
		this.orderDetail = orderDetail;
	}

	/**
	 * @return the idProduct
	 */
	public int getIdProduct() {
		return idProduct;
	}

	/**
	 * @param idProduct
	 *            the idProduct to set
	 */
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 *            the description to set
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
	 * @param quantity
	 *            the quantity to set
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
	 * @param price
	 *            the price to set
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
	 * @param created_date
	 *            the created_date to set
	 */
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

}

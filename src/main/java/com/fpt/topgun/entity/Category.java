package com.fpt.topgun.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "table_category")
public class Category {

	@Id
	@Column(name = "idCategory", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int idCategory;
	
	@Column(name = "name", nullable = false, length = 100)
	@NotNull
  @Size(min=2, max=99, message="Name should have atleast 2 characters and max is 99")
	private String name;
	
	@Column(name = "description", nullable = false, length = 255)
	@NotNull
  @Size(min=7, max=254, message="Description should have atleast 7 characters and max is 254")
	private String description;
	
	
	@OneToMany	
	private List<Product> product;
	/**
	 * 
	 */
	public Category() {
		super();
	}

	/**
	 * @return the idCategory
	 */
	public int getIdCategory() {
		return idCategory;
	}

	/**
	 * @param idCategory
	 *            the idCategory to set
	 */
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
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

}

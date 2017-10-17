package com.ubs.domainobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product")
public class ProductDO {

	public ProductDO() {

	}

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String description;
	
	private Double price;
	
	@Transient
	private SpecialOfferDO specialOfferDO;
	
	public ProductDO(long id) {
		this.id = id;
	}

	public ProductDO(long id, String name, String description, Double price, SpecialOfferDO specialOfferDO) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.specialOfferDO = specialOfferDO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public SpecialOfferDO getSpecialOfferDO() {
		return specialOfferDO;
	}

	public void setSpecialOfferDO(SpecialOfferDO specialOfferDO) {
		this.specialOfferDO = specialOfferDO;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String toString() {
		return "ProductDO [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", specialOfferDO=" + specialOfferDO + "]";
	}



}

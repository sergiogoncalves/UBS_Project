package com.ubs.domainobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "special_offer")
public class SpecialOfferDO {

	@Id
	@GeneratedValue
	private Long id;

	private Integer amount;

	private Double unit;

	private Double discount;
	
	@OneToOne
	@JoinColumn(name="product_id")
	private ProductDO productDO;

	public SpecialOfferDO() {
		
	}
	public SpecialOfferDO(Long id, Integer amount, Double unit, Double discount, ProductDO productDO) {
		this.id = id;
		this.amount = amount;
		this.unit = unit;
		this.discount = discount;
		this.productDO = productDO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getUnit() {
		return unit;
	}

	public void setUnit(Double unit) {
		this.unit = unit;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	public ProductDO getProductDO() {
		return productDO;
	}

	public void setProductDO(ProductDO productDO) {
		this.productDO = productDO;
	}

	@Override
	public String toString() {
		return "SpecialOfferDO [id=" + id + ", amount=" + amount + ", unit=" + unit + ", discount=" + discount + "]";
	}



}

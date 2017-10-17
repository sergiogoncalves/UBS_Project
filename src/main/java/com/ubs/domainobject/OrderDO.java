package com.ubs.domainobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.ubs.dataaccessobject.SpecialOfferRepository;
import com.ubs.util.Utils;

@Entity
@Table(name = "order_table")
public class OrderDO {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	@JoinColumn(name = "product_id")
	private ProductDO productDO;

	private int quantity;

	@Column(name = "total_price")
	private Double totalPrice;

	@Column(name = "promotion_offer")
	private boolean promotionOffer;
	
	public OrderDO() {

	}

	public OrderDO(Long id, ProductDO productDO, int quantity, Double totalPrice, boolean promotionOffer) {
		this.id = id;
		this.productDO = productDO;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.promotionOffer = promotionOffer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductDO getProductDO() {
		return productDO;
	}

	public void setProductDO(ProductDO productDO) {
		this.productDO = productDO;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isPromotionOffer() {
		return promotionOffer;
	}

	public void setPromotionOffer(boolean promotionOffer) {
		this.promotionOffer = promotionOffer;
	}


}

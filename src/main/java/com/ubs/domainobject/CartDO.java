package com.ubs.domainobject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "cart")
public class CartDO {

	@Id
	@GeneratedValue
	private Long id;
	
    
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id")
	private List<OrderDO> ordersDO;

	private String currency;
	
	@Transient
	private Double totalPrice;
	
	public CartDO() {
	}
	
	public CartDO(Long id, List<OrderDO> ordersDO, String currency, Double totalPrice) {
		this.id = id;
		this.ordersDO = ordersDO;
		this.currency = currency;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderDO> getOrdersDO() {
		return ordersDO;
	}

	public void setOrdersDO(List<OrderDO> ordersDO) {
		this.ordersDO = ordersDO;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}

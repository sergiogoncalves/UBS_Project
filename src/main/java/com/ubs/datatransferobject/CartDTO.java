package com.ubs.datatransferobject;

import java.util.List;


import com.ubs.domainobject.OrderDO;

public class CartDTO {

	private Long id;
	
	private List<OrderDTO> ordersDTO;

	private String currency;
	
	private Double totalPrice;
	
	public CartDTO () {
		
	}

	public CartDTO(Long id, List<OrderDTO> ordersDTO, String currency, Double totalPrice) {
		this.id = id;
		this.ordersDTO = ordersDTO;
		this.currency = currency;
		this.totalPrice = totalPrice;
	}


	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderDTO> getOrdersDTO() {
		return ordersDTO;
	}

	public void setOrdersDTO(List<OrderDTO> ordersDTO) {
		this.ordersDTO = ordersDTO;
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

	public static CartDTOBuilder newBuilder() {
		return new CartDTOBuilder();
	}
	
	public static class CartDTOBuilder{
		
		private Long id;
		
		private List<OrderDTO> ordersDTO;

		private String currency;
		
		private Double totalPrice;
				
		public CartDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public CartDTOBuilder setOrdersDTO(List<OrderDTO> ordersDTO) {
			this.ordersDTO = ordersDTO;
			return this;
		}

		public CartDTOBuilder setCurrency(String currency) {
			this.currency = currency;
			return this;
		}

		public CartDTOBuilder setTotalPrice(Double totalPrice) {
			this.totalPrice = totalPrice;
			return this;
		}

		public CartDTO createCartDTO() 
		{
			return new CartDTO(id, ordersDTO, currency, totalPrice);
		}
		
	}
	
}

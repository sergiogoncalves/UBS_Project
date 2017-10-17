package com.ubs.datatransferobject;

public class OrderDTO {

	private Long id;

	private ProductDTO productDTO;

	private int quantity;

	private Double totalPrice;

	private boolean promotionOffer;
	
	public OrderDTO() {
		
	}

	public OrderDTO(Long id, ProductDTO productDTO, int quantity, Double totalPrice, boolean promotionOffer) {
		this.id = id;
		this.productDTO = productDTO;
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
	
	public static OrderDTOBuilder newBuilder() {
		return new OrderDTOBuilder();
	}
	
	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}



	public static class OrderDTOBuilder {
		private Long id;
		private ProductDTO productDTO;
		private int quantity;
		private Double totalPrice;
		private boolean promotionOffer;
		
        public OrderDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public OrderDTOBuilder setProductDTO(ProductDTO productDTO) {
			this.productDTO = productDTO;
			return this;
		}

		public OrderDTOBuilder setQuantity(int quantity) {
			this.quantity = quantity;
			return this;
		}

		public OrderDTOBuilder setTotalPrice(Double totalPrice) {
			this.totalPrice = totalPrice;
			return this;
		}

		public OrderDTOBuilder setPromotionOffer(boolean promotionOffer) {
			this.promotionOffer = promotionOffer;
			return this;
		}

		public OrderDTO createOrderDTO()
        {
            return new OrderDTO(id, productDTO, quantity, totalPrice, promotionOffer);
        }

	}

}

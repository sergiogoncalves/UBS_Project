package com.ubs.datatransferobject;

public class SpecialOfferDTO {
	
	private Long id;

	private Integer amount;

	private Double unit;

	private Double discount;
	
	private Long productId;
	
	public SpecialOfferDTO() {
		
	}
	
	
	public SpecialOfferDTO(Long id, Integer amount, Double unit, Double discount, Long productId) {
		this.id = id;
		this.amount = amount;
		this.unit = unit;
		this.discount = discount;
		this.productId = productId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getUnit() {
		return unit;
	}

	public void setUnit(Double unit) {
		this.unit = unit;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public static SpecialOfferDTOBuilder newBuilder() {
		return new SpecialOfferDTOBuilder();
	}
	

	public static class SpecialOfferDTOBuilder {
		private Long id;
		private Integer amount;
		private Double unit;
		private Long productId;
		private Double discount;

		public SpecialOfferDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public SpecialOfferDTOBuilder setAmount(Integer amount) {
			this.amount = amount;
			return this;
		}

		public SpecialOfferDTOBuilder setUnit(Double unit) {
		    this.unit = unit;
			return this;
		}
		
		public SpecialOfferDTOBuilder setProductId(Long productId) {
		    this.productId = productId;
			return this;
		}
		
		public SpecialOfferDTOBuilder setDiscount(Double discount) {
		    this.discount = discount;
			return this;
		}
		
        public SpecialOfferDTO createSpecialOfferDTO()
        {
            return new SpecialOfferDTO(id, amount, unit, discount, productId);
        }

	}

	
	

}

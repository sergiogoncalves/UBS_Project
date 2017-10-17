package com.ubs.datatransferobject;

public class ProductDTO {

	private long id;
	private String name;
	private String description;
	private Double price;

	public ProductDTO() {
	}

	public ProductDTO(long id, String name, String description, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
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
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public static ProductDTOBuilder newBuilder() {
		return new ProductDTOBuilder();
	}

	public static class ProductDTOBuilder {
		private long id;
		private String name;
		private String description;
		private Double price;

		public ProductDTOBuilder setId(long id) {
			this.id = id;
			return this;
		}

		public ProductDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public ProductDTOBuilder setDescription(String description) {
		    this.description = description;
			return this;
		}
		
		public ProductDTOBuilder setPrice(Double price) {
		    this.price = price;
			return this;
		}
		
        public ProductDTO createProductDTO()
        {
            return new ProductDTO(id, name, description, price);
        }

	}

}

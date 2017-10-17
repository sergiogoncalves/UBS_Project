package com.ubs.domainvalue;

public class Messages {
	
	public static final String CART_DTO_STRING = "{\"id\":null,\"ordersDTO\":[],\"currency\":\"Euro\",\"totalPrice\":1000.0}";
	
	public static final String ORDER_DO_STRING = "{\"id\":3,\"productDO\":{\"id\":1,\"name\":\"test\",\"description\":\"test\",\"price\":1.0},\"quantity\":5,\"totalPrice\":0.0,\"promotionOffer\":false}";
	
	public static final String ORDER_DO_STRING_ID_02 = "{\"id\":1,\"productDTO\":{\"id\":1,\"name\":\"test\",\"description\":\"test\",\"price\":1.0},\"quantity\":5,\"totalPrice\":0.0,\"promotionOffer\":true}";
	
	public static final String ORDER_DO_STRING_03 = "{\"id\": 2, \"productDTO\": {\"id\": 2, \"name\": \"MOTO Z\", \"description\": \"New Mobile from Motorola\",\"price\": 750},\"quantity\": 2,\"totalPrice\": 1125,\"promotionOffer\": true}";
	
	public static final String ORDER_DTO_STRING = "{\"id\":1,\"productDTO\":{\"id\":1,\"name\":\"test\",\"description\":\"test\",\"price\":1.0},\"quantity\":5,\"totalPrice\":0.0,\"promotionOffer\":false}";
	
	public static final String ORDER_DO_WITH_ERROR_STRING = "{ \"idS\": 1, \"productIdS\": 1, \"quantity\": 2, \"totalPrice\": 3000, \"promotionOffer\": false}";
	
	public static final String PRODUCT_DO_STRING = "{\"description\": \"LG Prime mobile phone\",\"id\": 0,\"name\": \"LG Prime\",\"price\": 950.50}";

	public static final String SPECIAL_OFFER_DO_STRING = "{\"amount\": 2,\"discount\": 25,\"id\": 0,\"productId\": 2,\"unit\": 10}";
	
	
}

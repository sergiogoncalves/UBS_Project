package com.ubs.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ubs.dataaccessobject.SpecialOfferRepository;
import com.ubs.domainobject.OrderDO;

@Service
public class Utils {
	
	@Autowired
	private SpecialOfferRepository specialOfferRepository;
	
	public Utils(final SpecialOfferRepository specialOfferRepository) {
		
		this.specialOfferRepository = specialOfferRepository;
	}

	public static Double calculateSpecialOffer(int quantityRequested, Double price, Double discount, int amount) {
		
		Double specialPrice = 0d;
		
		if (quantityRequested >= amount) {
			
			Double totalPrice = (quantityRequested * price);
			
			Double totalDiscount = totalPrice * (discount / 100);
			
			specialPrice =  totalPrice - totalDiscount;
		}
		else{
			specialPrice = (quantityRequested * price);
		}
		
		return Math.floor(specialPrice);
	}
	
	public static Double calculateNormalPrice(int quantityRequested, Double price) {
		
		Double totalPrice = (double) (quantityRequested * price);
		
		return totalPrice;
	}
	
	/**
	 * Method used to transform a JSON file in a Object
	 * @param jsonFile
	 * @param object
	 * @return
	 */
	public static Object getConvertedObject(String jsonFile, Object object) {
		Gson gson = new Gson();
		return gson.fromJson(jsonFile, object.getClass());
	}
	
	public static String convertObjectToJson(Object object) {
		Gson gson = new Gson();
		
		return gson.toJson(object);
	}
	
	public Double calculateTotal(OrderDO orderDO) {
		
		Double totalPrice = 0d;
		
		if (orderDO.getProductDO() != null) {
			orderDO.getProductDO().setSpecialOfferDO(specialOfferRepository.findByProductDO(orderDO.getProductDO()));
		}

		if (orderDO.getProductDO() != null && orderDO.getProductDO().getSpecialOfferDO() != null) {
			
			orderDO.setPromotionOffer(true);
			totalPrice = Utils.calculateSpecialOffer(orderDO.getQuantity(), 
													 orderDO.getProductDO().getPrice(),
					                                 orderDO.getProductDO().getSpecialOfferDO().getDiscount(), 
					                                 orderDO.getProductDO().getSpecialOfferDO().getAmount());
		} else {

			if (orderDO.getProductDO() != null) {
				totalPrice = Utils.calculateNormalPrice(orderDO.getQuantity(), orderDO.getProductDO().getPrice());
			}
		}
		
		orderDO.setTotalPrice(totalPrice);
		
		return totalPrice;
	}

}

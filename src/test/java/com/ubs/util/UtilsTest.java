package com.ubs.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ubs.datatransferobject.CartDTO;
import com.ubs.datatransferobject.OrderDTO;
import com.ubs.datatransferobject.ProductDTO;
import com.ubs.domainobject.OrderDO;
import com.ubs.domainobject.ProductDO;
import com.ubs.domainobject.SpecialOfferDO;
import com.ubs.domainvalue.Messages;

public class UtilsTest {

	@Test
	public void shouldReturnRightCalculatedSpecialOfferExpected70() {
		
	
		Double expected = 70d;
		Double price = 40d;
		int quantityRequested = 3;
		int amount = 3;
		Double discount = 41.66d;
		
		Double actual = Utils.calculateSpecialOffer(quantityRequested, price, discount, amount);
		
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void shouldReturnWrongCalculatedSpecialOffer() {
		
		Double expected = 70d;
		Double price = 40d;
		int quantityRequested = 3;
		int amount = 4;
		Double discount = 58.33d;
		
		Double actual = Utils.calculateSpecialOffer(quantityRequested, price, discount, amount);
		
		
		assertNotEquals(expected, actual);
		
	}
	
	@Test
	public void shouldReturnRightCalculatedSpecialOfferExpected15() {
		
		Double expected = 15d;
		Double price = 10d;
		int quantityRequested = 2;
		int amount = 2;
		Double discount = 25d;
		
		Double actual = Utils.calculateSpecialOffer(quantityRequested, price, discount, amount);
		
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void shouldReturnRightNormalPrice_01() {
		
		Double expected = 3000d;
		Double price = 1500d;
		int quantityRequested = 2;
		
		Double actual = Utils.calculateNormalPrice(quantityRequested, price);
		
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnRightNormalPrice_02() {
		
		Double expected = 2250d;
		Double price = 1125d;
		int quantityRequested = 2;
		
		Double actual = Utils.calculateNormalPrice(quantityRequested, price);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnWrongNormalPrice_01() {
		
		Double expected = 2250d;
		Double price = 1125d;
		int quantityRequested = 3;
		
		Double actual = Utils.calculateNormalPrice(quantityRequested, price);
		
		assertNotEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnWrongNormalPrice_02() {
		
		Double expected = 2250d;
		Double price = 1125d;
		int quantityRequested = 7;
		
		Double actual = Utils.calculateNormalPrice(quantityRequested, price);
		
		assertNotEquals(expected, actual);
	}
	
	
	@Test
	public void shouldReturnAnOrderDOObject() {
		
     	assertTrue(Utils.getConvertedObject(Messages.ORDER_DO_STRING, new OrderDO()) instanceof OrderDO);
		
	}
	
	@Test
	public void shouldFailToReturnAObject() {
		
     	assertTrue(Utils.getConvertedObject(Messages.ORDER_DO_WITH_ERROR_STRING, new OrderDO()) instanceof OrderDO);
	}
	
	@Test
	public void shouldConvertObjectToJson() {
	
		OrderDTO orderDTO = new OrderDTO(1l, new ProductDTO(1, "test", "test", 1.00), 5, 0d, false);
		
		assertEquals(Messages.ORDER_DTO_STRING, Utils.convertObjectToJson(orderDTO));
		
	}
	
}

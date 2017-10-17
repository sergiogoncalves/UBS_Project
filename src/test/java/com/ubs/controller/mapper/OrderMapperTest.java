package com.ubs.controller.mapper;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ubs.datatransferobject.OrderDTO;
import com.ubs.domainobject.OrderDO;
import com.ubs.domainvalue.Messages;
import com.ubs.exception.EntityNotFoundException;
import com.ubs.util.Utils;

public class OrderMapperTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void shouldReturnAOrderDTOObjectByString()  {
		
		OrderDO orderDO =  (OrderDO) Utils.getConvertedObject(Messages.ORDER_DO_STRING, new OrderDO());
		
		assertTrue(OrderMapper.makeOrdertDTO(orderDO)  instanceof OrderDTO);

	}
	
	@Test
	public void shouldReturnAOrderDOObjectByString() throws EntityNotFoundException  {
		
		OrderDTO orderDTO =  (OrderDTO) Utils.getConvertedObject(Messages.ORDER_DTO_STRING, new OrderDTO());
		
		assertTrue(OrderMapper.makeOrderDO(orderDTO) instanceof OrderDO);

	}
}

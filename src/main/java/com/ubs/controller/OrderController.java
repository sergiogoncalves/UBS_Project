package com.ubs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.ubs.controller.mapper.OrderMapper;
import com.ubs.datatransferobject.OrderDTO;
import com.ubs.domainobject.OrderDO;
import com.ubs.exception.ConstraintsViolationException;
import com.ubs.exception.EntityNotFoundException;
import com.ubs.service.order.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	private OrderService orderService;

	@Autowired
	public OrderController(final OrderService orderService) {

		this.orderService = orderService;
	}
	
    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@Valid @RequestBody OrderDTO orderDTO) throws ConstraintsViolationException 
    {
    	OrderDO orderDO = OrderMapper.makeOrderDO(orderDTO);
    	orderService.create(orderDO);
    }
    
    @GetMapping("/{id}")
    public OrderDTO getOrder(@Valid @PathVariable long id) throws EntityNotFoundException 
    {
      return OrderMapper.makeOrdertDTO(orderService.find(id));
    }
    
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDTO updateOrder(@Valid @RequestBody OrderDTO orderDTO) throws EntityNotFoundException, ConstraintsViolationException 
    {
    	OrderDO orderDO = OrderMapper.makeOrderDO(orderDTO);
    	return OrderMapper.makeOrdertDTO(orderService.update(orderDO));
    }
    
    @DeleteMapping("/{id}")
    public void deleteOrder(@Valid @PathVariable long id) throws EntityNotFoundException, ConstraintsViolationException 
    {
    	orderService.delete(id);
    }


}

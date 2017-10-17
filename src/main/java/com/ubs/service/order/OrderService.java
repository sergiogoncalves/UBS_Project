package com.ubs.service.order;

import java.util.List;

import com.ubs.domainobject.OrderDO;
import com.ubs.exception.ConstraintsViolationException;
import com.ubs.exception.EntityNotFoundException;

public interface OrderService {
	
	OrderDO find(Long orderId) throws EntityNotFoundException;
	
	List<OrderDO> findAll() throws EntityNotFoundException;
	
	OrderDO create(OrderDO orderDO) throws ConstraintsViolationException;
	
	OrderDO update(OrderDO orderDO) throws ConstraintsViolationException;

	void delete(Long orderId) throws EntityNotFoundException;

}

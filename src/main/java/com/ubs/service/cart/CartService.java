package com.ubs.service.cart;

import java.util.List;

import com.ubs.domainobject.CartDO;
import com.ubs.domainobject.OrderDO;
import com.ubs.exception.ConstraintsViolationException;
import com.ubs.exception.EntityNotFoundException;

public interface CartService {
	
	CartDO find(Long cartId) throws EntityNotFoundException;
	
	List<CartDO> findAll() throws EntityNotFoundException;
	
	CartDO create(CartDO cartDO) throws ConstraintsViolationException;
	
	void update(CartDO cartDO) throws ConstraintsViolationException, EntityNotFoundException;

	void delete(Long idCart) throws EntityNotFoundException;
	
	Double getAtualPrice(Long idCart, OrderDO orderDO) throws EntityNotFoundException;
	
	Double getTotalPrice(Long idCart) throws EntityNotFoundException;

}

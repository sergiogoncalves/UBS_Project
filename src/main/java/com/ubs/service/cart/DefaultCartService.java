package com.ubs.service.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubs.dataaccessobject.CartRepository;
import com.ubs.domainobject.CartDO;
import com.ubs.domainobject.OrderDO;
import com.ubs.exception.ConstraintsViolationException;
import com.ubs.exception.EntityNotFoundException;
import com.ubs.util.Utils;

@Service
public class DefaultCartService implements CartService {

	@Autowired
	private CartRepository cartRepository;
	

	@Autowired
	private Utils utils;

	
	public DefaultCartService(final CartRepository cartRepository, final Utils utils) {
		this.cartRepository = cartRepository;
		this.utils = utils;
		
	}

	public CartDO find(Long idCart) throws EntityNotFoundException {
		
		CartDO cartDO = findCartChecked(idCart);
		
		cartDO.setTotalPrice(getTotalPrice(cartDO));

		return cartDO;
	}


	public List<CartDO> findAll() throws EntityNotFoundException {
		
		return (List<CartDO>) cartRepository.findAll();
	}

    @Transactional
	public CartDO create(CartDO cartDO) throws ConstraintsViolationException {

    	return cartRepository.save(cartDO);
	}

    @Transactional
	public void update(CartDO cartDO) throws ConstraintsViolationException, EntityNotFoundException {
    	cartRepository.save(cartDO);
	}

    @Transactional
	public void delete(Long idCart) throws EntityNotFoundException {
		
		CartDO cartDO = findCartChecked(idCart);
		
		cartRepository.delete(cartDO);
	}


	public Double getAtualPrice(Long idCart, OrderDO orderDO) throws EntityNotFoundException {
		
		return null;
	}

	
	public Double getTotalPrice(Long idCart) throws EntityNotFoundException {
		
		CartDO cartDO = findCartChecked(idCart);
		
		return getTotalPrice(cartDO);
	}
	
	private Double getTotalPrice(CartDO cartDO) throws EntityNotFoundException {
		
		Double totalPrice = 0d;
		
		for (OrderDO actualCart : cartDO.getOrdersDO()) {
			totalPrice += utils.calculateTotal(actualCart);
		}
	
		return totalPrice;
	}

	private CartDO findCartChecked(Long idCart) throws EntityNotFoundException {
		
		CartDO cartDO = cartRepository.findOne(idCart);
		
		if (cartDO == null) {
			throw new EntityNotFoundException("Could not find entity with id: " + idCart);
		}

		return cartDO;
	}
	

	


}

package com.ubs.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.LoggerFactory;

import com.ubs.dataaccessobject.OrderRepository;
import com.ubs.domainobject.OrderDO;
import com.ubs.exception.ConstraintsViolationException;
import com.ubs.exception.EntityNotFoundException;
import com.ubs.util.Utils;

@Service
public class DefaultOrderService implements OrderService {

	private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultOrderService.class);

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private Utils utils;

	public DefaultOrderService(final OrderRepository orderRepository, final Utils utils) {
		this.orderRepository = orderRepository;
		this.utils = utils;
	}

	public OrderDO find(Long orderId) throws EntityNotFoundException {

		return findOrderChecked(orderId);
	}

	public List<OrderDO> findAll() throws EntityNotFoundException {

		return (List<OrderDO>) orderRepository.findAll();
	}

    @Transactional
	public OrderDO create(OrderDO orderDO) throws ConstraintsViolationException {
		try {
			return orderRepository.save(orderDO);
		} catch (DataIntegrityViolationException e) {
			LOG.warn("Some constraints are thrown due to order creation", e);
			throw new ConstraintsViolationException(e.getMessage());
		}
	}

	@Transactional
	public OrderDO update(OrderDO orderDO) throws ConstraintsViolationException {

		return orderRepository.save(orderDO);
	}
	
	@Transactional
	public void delete(Long orderId) throws EntityNotFoundException {

		OrderDO orderDO = orderRepository.findOne(orderId);

		if (orderDO == null) {
			throw new EntityNotFoundException("Could not find entity with id: " + orderId);
		}
		
		orderRepository.delete(orderDO);
	}

	private OrderDO findOrderChecked(Long orderId) throws EntityNotFoundException {
		OrderDO orderDO = orderRepository.findOne(orderId);

		if (orderDO == null) {
			throw new EntityNotFoundException("Could not find entity with id: " + orderId);
		}

		utils.calculateTotal(orderDO);
		
		return orderDO;
	}

}

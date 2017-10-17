package com.ubs.dataaccessobject;


import org.springframework.data.repository.CrudRepository;
import com.ubs.domainobject.OrderDO;

public interface OrderRepository  extends CrudRepository<OrderDO, Long> {
	
}

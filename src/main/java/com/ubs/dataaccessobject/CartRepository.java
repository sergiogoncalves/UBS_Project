package com.ubs.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.ubs.domainobject.CartDO;

public interface CartRepository extends CrudRepository<CartDO, Long>  {

}

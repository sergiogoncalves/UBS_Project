package com.ubs.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.ubs.domainobject.ProductDO;

public interface ProductRepository extends CrudRepository<ProductDO, Long>{

}

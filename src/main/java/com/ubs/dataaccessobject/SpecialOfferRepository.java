package com.ubs.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.ubs.domainobject.ProductDO;
import com.ubs.domainobject.SpecialOfferDO;

public interface SpecialOfferRepository extends CrudRepository<SpecialOfferDO, Long>{
	
	public SpecialOfferDO  findByProductDO(ProductDO productDO);

}

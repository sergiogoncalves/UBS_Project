package com.ubs.service.product;

import java.util.List;

import com.ubs.domainobject.ProductDO;
import com.ubs.exception.ConstraintsViolationException;
import com.ubs.exception.EntityNotFoundException;

public interface ProductService {
	
	ProductDO find(Long productId) throws EntityNotFoundException;
	
	List<ProductDO> findAll() throws EntityNotFoundException;
	
	ProductDO create(ProductDO productDO) throws ConstraintsViolationException;

}

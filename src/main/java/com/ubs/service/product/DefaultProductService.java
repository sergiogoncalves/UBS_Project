package com.ubs.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubs.dataaccessobject.ProductRepository;
import com.ubs.domainobject.ProductDO;
import com.ubs.exception.ConstraintsViolationException;
import com.ubs.exception.EntityNotFoundException;

@Service
public class DefaultProductService implements ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	public DefaultProductService(final ProductRepository productRepository ) {
		this.productRepository = productRepository;
	}
	
	public ProductDO find(Long productId) throws EntityNotFoundException {

		return findProductChecked(productId);
	}

	public List<ProductDO> findAll() throws EntityNotFoundException {
		
		return (List<ProductDO>) productRepository.findAll();
		
	}

    @Transactional
	public ProductDO create(ProductDO productDO) throws ConstraintsViolationException {
		
		return productRepository.save(productDO);
	}
    
    private ProductDO findProductChecked(Long productId) throws EntityNotFoundException
    {
    	ProductDO productDO = productRepository.findOne(productId);
    	
        if (productDO == null)
        {
            throw new EntityNotFoundException("Could not find entity with id: " + productId);
        }
        
        return productDO;
    }

}

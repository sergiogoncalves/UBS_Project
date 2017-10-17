package com.ubs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.controller.mapper.ProductMapper;
import com.ubs.datatransferobject.ProductDTO;
import com.ubs.domainobject.ProductDO;
import com.ubs.exception.ConstraintsViolationException;
import com.ubs.exception.EntityNotFoundException;
import com.ubs.service.product.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
		
	private ProductService productService;

	@Autowired
	public ProductController(final ProductService productService) {

		this.productService = productService;
	}
	
    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public void receiveLeft(@Valid @RequestBody ProductDTO productDTO) throws ConstraintsViolationException 
    {
    	ProductDO productDO = ProductMapper.makeProductDO(productDTO);
    	productService.create(productDO);
    }
    
    
    @GetMapping("/{id}")
    public ProductDTO getProduct(@Valid @PathVariable long id) throws EntityNotFoundException 
    {
      return ProductMapper.makeProductDTO(productService.find(id));
    }
    
    @GetMapping
    public List<ProductDTO> getAllProduct() throws EntityNotFoundException 
    {
      return ProductMapper.makeProductDTOList(productService.findAll());
    }

}

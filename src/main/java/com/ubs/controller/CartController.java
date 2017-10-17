package com.ubs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.controller.mapper.CartMapper;
import com.ubs.datatransferobject.CartDTO;
import com.ubs.exception.ConstraintsViolationException;
import com.ubs.exception.EntityNotFoundException;
import com.ubs.service.cart.CartService;


@RestController
@RequestMapping("/cart")
public class CartController {
	
	private CartService cartService;

	@Autowired
	public CartController(final CartService cartService) {

		this.cartService = cartService;
	}
	
    @GetMapping("/{idCart}")
    public CartDTO getCart(@Valid @PathVariable long idCart) throws EntityNotFoundException 
    {
      return CartMapper.makeCartDTO(cartService.find(idCart));
    }
   
    @GetMapping
    public List<CartDTO> getAllCart() throws EntityNotFoundException 
    {
      return CartMapper.makeCartDTOList(cartService.findAll());
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartDTO createCart(@Valid @RequestBody CartDTO cartDTO) throws EntityNotFoundException, ConstraintsViolationException 
    {
      return CartMapper.makeCartDTO(cartService.create(CartMapper.makeCartDO(cartDTO)));
    }
    
    @DeleteMapping("/{idCart}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCart(@Valid @PathVariable long idCart) throws EntityNotFoundException 
    {
    	cartService.delete(idCart);
    }
    
    @GetMapping("/{idCart}/total")
    public Double getCartTotalPrice(@Valid @PathVariable long idCart) throws EntityNotFoundException 
    {
      return cartService.getTotalPrice(idCart);
    }
    
    @PutMapping("/{idCart}")
    public void updateCart(@Valid @PathVariable long idCart, @Valid @RequestBody CartDTO cartDTO) throws EntityNotFoundException, ConstraintsViolationException 
    {
       cartService.update(CartMapper.makeCartDO(cartDTO));
    }

}

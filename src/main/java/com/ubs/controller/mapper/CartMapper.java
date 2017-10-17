package com.ubs.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.ubs.datatransferobject.CartDTO;
import com.ubs.domainobject.CartDO;



public class CartMapper {
	
	public static CartDO makeCartDO(CartDTO cartDTO) {
		
		
		return new CartDO(cartDTO.getId(), 
						  OrderMapper.makeOrderDOList(cartDTO.getOrdersDTO()), 
						  cartDTO.getCurrency(), 
						  cartDTO.getTotalPrice());
		
	}
	
	public static CartDTO makeCartDTO(CartDO cartDO) {
		
		
		CartDTO.CartDTOBuilder cartDTOBuilder = CartDTO.newBuilder()
								.setId(cartDO.getId())
								.setCurrency(cartDO.getCurrency())
								.setTotalPrice(cartDO.getTotalPrice())
								.setOrdersDTO(OrderMapper.makeOrderDTOList(cartDO.getOrdersDO()));
		
		
		return cartDTOBuilder.createCartDTO();
		
   }
	
    public static List<CartDTO> makeCartDTOList(Collection<CartDO> cartsDO)
    {
        return cartsDO.stream()
                .map(CartMapper:: makeCartDTO)
                .collect(Collectors.toList());
    }

}

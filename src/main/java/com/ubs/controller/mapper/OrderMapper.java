package com.ubs.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubs.datatransferobject.OrderDTO;
import com.ubs.domainobject.OrderDO;
import com.ubs.domainobject.ProductDO;
import com.ubs.exception.EntityNotFoundException;
import com.ubs.service.product.ProductService;

@Service
public class OrderMapper {
	
	public static OrderDO makeOrderDO(OrderDTO orderDTO) {
		
	
		return new OrderDO(orderDTO.getId(), 
						   ProductMapper.makeProductDO(orderDTO.getProductDTO()), 
				           orderDTO.getQuantity(),
				           orderDTO.getTotalPrice(),
				           orderDTO.isPromotionOffer());
	}
	
	public static OrderDTO makeOrdertDTO(OrderDO orderDO) {
		
		
		OrderDTO.OrderDTOBuilder ordertDTOBuilder = OrderDTO.newBuilder()
								.setId(orderDO.getId())
						        .setQuantity(orderDO.getQuantity())
							    .setTotalPrice(orderDO.getTotalPrice())
							    .setPromotionOffer(orderDO.isPromotionOffer())
							    .setProductDTO(ProductMapper.makeProductDTO(orderDO.getProductDO()));
		
		return ordertDTOBuilder.createOrderDTO();
		
   }
	
    public static List<OrderDTO> makeOrderDTOList(Collection<OrderDO> ordersDO)
    {
        return ordersDO.stream()
                .map(OrderMapper::makeOrdertDTO)
                .collect(Collectors.toList());
    }
    
    public static List<OrderDO> makeOrderDOList(Collection<OrderDTO> ordersDTO)
    {
        return ordersDTO.stream()
                .map(OrderMapper::makeOrderDO)
                .collect(Collectors.toList());
    }

}

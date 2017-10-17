package com.ubs.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.ubs.datatransferobject.ProductDTO;
import com.ubs.domainobject.ProductDO;


public class ProductMapper {
	
	public static ProductDO makeProductDO(ProductDTO productDTO) {
		return new ProductDO(productDTO.getId(), productDTO.getName(), productDTO.getDescription(), productDTO.getPrice(), null);
	}
	
	public static ProductDTO makeProductDTO(ProductDO productDO) {

		ProductDTO.ProductDTOBuilder productDTOBuilder = ProductDTO.newBuilder()
							.setId(productDO.getId())
							.setName(productDO.getName())
							.setDescription(productDO.getDescription())
							.setPrice(productDO.getPrice());
		
		return productDTOBuilder.createProductDTO();
		
   }
	
    public static List<ProductDTO> makeProductDTOList(Collection<ProductDO> productsDO)
    {
        return productsDO.stream()
                .map(ProductMapper::makeProductDTO)
                .collect(Collectors.toList());
    }

}

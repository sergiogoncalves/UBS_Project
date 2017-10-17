package com.ubs.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.ubs.datatransferobject.SpecialOfferDTO;
import com.ubs.domainobject.ProductDO;
import com.ubs.domainobject.SpecialOfferDO;


public class SpecialOfferMapper {
	
	public static SpecialOfferDO makeSpecialOfferDO(SpecialOfferDTO specialOfferDTO) {
		
		
		ProductDO productDO = new ProductDO(specialOfferDTO.getProductId());
		
		return new SpecialOfferDO(specialOfferDTO.getId(), 
								  specialOfferDTO.getAmount(), 
								  specialOfferDTO.getUnit(), 
								  specialOfferDTO.getDiscount(),
								  productDO);
	}
	
	public static SpecialOfferDTO makeSpecialOfferDTO(SpecialOfferDO specialOfferDO) {
		
		SpecialOfferDTO.SpecialOfferDTOBuilder specialOfferDTOBuilder = SpecialOfferDTO.newBuilder()
				.setId(specialOfferDO.getId())
				.setAmount(specialOfferDO.getAmount())
				.setDiscount(specialOfferDO.getDiscount())
				.setUnit(specialOfferDO.getUnit())
				.setProductId(specialOfferDO.getProductDO().getId());
		
		
		return specialOfferDTOBuilder.createSpecialOfferDTO();
		
   }
	
    public static List<SpecialOfferDTO> makeSpecialOfferDTOList(Collection<SpecialOfferDO> specialOffersDO)
    {
        return specialOffersDO.stream()
                .map(SpecialOfferMapper::makeSpecialOfferDTO)
                .collect(Collectors.toList());
    }

}

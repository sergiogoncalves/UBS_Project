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

import com.ubs.controller.mapper.SpecialOfferMapper;
import com.ubs.datatransferobject.SpecialOfferDTO;
import com.ubs.domainobject.SpecialOfferDO;
import com.ubs.exception.ConstraintsViolationException;
import com.ubs.exception.EntityNotFoundException;
import com.ubs.service.specialoffer.SpecialOfferService;



@RestController
@RequestMapping("/specialoffer")
public class SpecialOfferController {
	
	private SpecialOfferService specialOfferService;

	@Autowired
	public SpecialOfferController(final SpecialOfferService specialOfferService) {

		this.specialOfferService = specialOfferService;
	}
	
	
    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public void createSpecialOffer(@Valid @RequestBody SpecialOfferDTO specialOfferDTO) throws ConstraintsViolationException
    {
    	SpecialOfferDO specialOfferDO = SpecialOfferMapper.makeSpecialOfferDO(specialOfferDTO);
    	specialOfferService.create(specialOfferDO);
    }
    
    
    @GetMapping("/{id}")
    public SpecialOfferDTO getSpecialOffer(@Valid @PathVariable long id) throws EntityNotFoundException 
    {
      return SpecialOfferMapper.makeSpecialOfferDTO(specialOfferService.find(id));
    }
    
    @GetMapping
    public List<SpecialOfferDTO> getAllSpecialOffers() throws EntityNotFoundException 
    {
      return SpecialOfferMapper.makeSpecialOfferDTOList(specialOfferService.findAll());
    }
	

}

package com.ubs.service.specialoffer;

import java.util.List;


import com.ubs.domainobject.SpecialOfferDO;
import com.ubs.exception.ConstraintsViolationException;
import com.ubs.exception.EntityNotFoundException;

public interface SpecialOfferService {
	
	SpecialOfferDO find(Long offerId) throws EntityNotFoundException;
	
	List<SpecialOfferDO> findAll() throws EntityNotFoundException;
	
	SpecialOfferDO create(SpecialOfferDO specialOfferDO) throws ConstraintsViolationException;

}

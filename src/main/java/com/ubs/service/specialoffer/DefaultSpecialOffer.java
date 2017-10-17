package com.ubs.service.specialoffer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubs.dataaccessobject.SpecialOfferRepository;
import com.ubs.domainobject.ProductDO;
import com.ubs.domainobject.SpecialOfferDO;
import com.ubs.exception.ConstraintsViolationException;
import com.ubs.exception.EntityNotFoundException;

@Service
public class DefaultSpecialOffer implements SpecialOfferService {
	
	@Autowired
	private SpecialOfferRepository specialOfferRepository;
	
	public DefaultSpecialOffer(final SpecialOfferRepository specialOfferRepository ) {
		this.specialOfferRepository = specialOfferRepository;
	}

	@Override
	public SpecialOfferDO find(Long offerId) throws EntityNotFoundException {
		
		return findSpecialOfferChecked(offerId);
	}

	@Override
	public List<SpecialOfferDO> findAll() throws EntityNotFoundException {
		
		return (List<SpecialOfferDO>) specialOfferRepository.findAll();
	}

    @Transactional
	public SpecialOfferDO create(SpecialOfferDO specialOfferDO) throws ConstraintsViolationException {

    	return specialOfferRepository.save(specialOfferDO);
    	
	}
    
    private SpecialOfferDO findSpecialOfferChecked(Long offerId) throws EntityNotFoundException
    {
    	SpecialOfferDO specialOfferDO = specialOfferRepository.findOne(offerId);
    	
        if (specialOfferDO == null)
        {
            throw new EntityNotFoundException("Could not find entity with id: " + offerId);
        }
        
        return specialOfferDO;
    }

}

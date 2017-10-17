package com.ubs.dataaccessobject;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubs.domainobject.ProductDO;
import com.ubs.domainobject.SpecialOfferDO;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class SpecialOfferRepositoryTest {

	@Autowired
	SpecialOfferRepository specialOfferRepository;
	
	public SpecialOfferRepositoryTest() {
	}
	
    @Test
    public void shouldFindAProductByProductDO() throws Exception {
    	ProductDO productDO = new ProductDO(1);

        SpecialOfferDO specialOfferDO = specialOfferRepository.findByProductDO(productDO);
        
        Long expected = 1L;
        Long actual =  specialOfferDO.getId();

        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldNotFindAProductByProductDO() throws Exception {
    	ProductDO productDO = new ProductDO(200);

        SpecialOfferDO specialOfferDO = specialOfferRepository.findByProductDO(productDO);

        assertEquals(specialOfferDO, null);
    }
	
}

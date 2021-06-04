package com.pack.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.pack.entity.Beneficiary;
import com.pack.exception.BeneficiaryExistsException;
import com.pack.service.BeneficiaryService;


@AutoConfigureTestDatabase(replace=Replace.NONE)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BeneficiaryControllerTest {

	
	@Mock
	BeneficiaryService beneficiaryService;
	
	@InjectMocks
	BeneficiaryController beneficiaryController;
	
	@Test
	@DisplayName("Beneficiary")
	void testAddBeneficiary() throws BeneficiaryExistsException  {
		
			Beneficiary beneficiary = new Beneficiary();
		
			beneficiary.setBid(118L);
			beneficiary.setAcno(1957382569L);
			beneficiary.setIfsc("Andhra1345");
			beneficiary.setBank("Andhra Bank");
			beneficiary.setBranch("gudur");
			beneficiary.setName("Pandya");
			
when(beneficiaryService.getBeneficiaryByAcno(beneficiary.getAcno())).thenReturn(null);	

when(beneficiaryService.addBeneficiary(beneficiary)).thenReturn(beneficiary);

		ResponseEntity<String> addBeneficiary = beneficiaryController.addBeneficiary(beneficiary);

		assertEquals("Beneficiary added Successfully", addBeneficiary.getBody());
	}
	
}

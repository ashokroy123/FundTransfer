package com.pack.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.pack.entity.Beneficiary;
import com.pack.entity.Customer;
import com.pack.repository.BeneficiaryRepository;


@AutoConfigureTestDatabase(replace=Replace.NONE)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BeneficiaryServiceTest {

	@Mock
	BeneficiaryRepository beneficiaryRepository;
	
	@InjectMocks
	BeneficiaryService beneficiaryService;
	
	
	
	@Test
	public void addBeneficiaryTest() {
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setBid(109L);
		beneficiary.setAcno(1957382560L);
		beneficiary.setBank("Andhra Bank");
		beneficiary.setBranch("Podalakur");
		beneficiary.setName("rassul");
		beneficiaryService.addBeneficiary(beneficiary);

		verify(beneficiaryRepository, times(1)).save(beneficiary);

	}

	@Test
	public void getBeneficiaryByAcnoTest() {
		Beneficiary beneficiary = new Beneficiary();
	
		beneficiary.setBid(110L);
		beneficiary.setAcno(1957382567L);
		beneficiary.setIfsc("Andhra1345");
		beneficiary.setBank("Andhra Bank");
		beneficiary.setBranch("gudur");
		beneficiary.setName("Pandya");
		
		
		when(beneficiaryRepository.findByAcno(beneficiary.getAcno())).thenReturn(beneficiary);

Beneficiary beneficiaryByAcno = beneficiaryService.getBeneficiaryByAcno(beneficiary.getAcno());
		
		assertTrue(beneficiaryByAcno.getBid()==beneficiary.getBid());
	
	}
}

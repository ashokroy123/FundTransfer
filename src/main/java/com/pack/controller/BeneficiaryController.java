
package com.pack.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Beneficiary;
import com.pack.entity.Customer;
import com.pack.exception.BeneficiaryExistsException;
import com.pack.service.BeneficiaryService;
import com.pack.service.CustomerService;

@RestController
public class BeneficiaryController {
	static Logger log = LoggerFactory.getLogger(BeneficiaryController.class.getName());

	@Autowired
	BeneficiaryService beneficiaryService;

	@Autowired
	CustomerService customerService;

	@PutMapping("/beneficiary")
	public ResponseEntity<String> addBeneficiary(@Valid @RequestBody Beneficiary beneficiary)
			throws BeneficiaryExistsException {
		String message = "";

		if (getBeneficiaryByAcno(beneficiary.getAcno()) != null) {
			log.error("Beneficiary already exists");
			throw new BeneficiaryExistsException(" Beneficiary already exists");
		} else {
			message ="Beneficiary added Successfully";
			log.info("Beneficiary added successfully");
			beneficiaryService.addBeneficiary(beneficiary);

			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
	}

		public Beneficiary getBeneficiaryByAcno(Long acno) {
		return beneficiaryService.getBeneficiaryByAcno(acno);
	}
}

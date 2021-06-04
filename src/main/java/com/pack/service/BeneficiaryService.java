
package com.pack.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entity.Beneficiary;
import com.pack.repository.BeneficiaryRepository;

@Service
public class BeneficiaryService {

	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	
	  public Beneficiary addBeneficiary(Beneficiary beneficiary) { return
	  beneficiaryRepository.save(beneficiary); }
	 

	public Beneficiary getBeneficiaryByAcno(Long acno) {
		return beneficiaryRepository.findByAcno(acno);
	}

	
	
	 /* public void deleteBeneficiary(Long bid) {
	  beneficiaryRepository.deleteById(bid); }
	 
	  
	  public List<Beneficiary> getAllBeneficiariesByAcno(Long acno) {
	  List<Beneficiary> findAll = beneficiaryRepository.findAll();
	  
	  return findAll.stream().filter(beneficiary ->
	  beneficiary.getCustomer().getAcno() == acno) .collect(Collectors.toList());
	  }
	 */

}

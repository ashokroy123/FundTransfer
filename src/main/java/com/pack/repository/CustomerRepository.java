package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.entity.Beneficiary;
import com.pack.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByEmail(String email);

	Customer findByAccno(Long accno);

	
	

	//public Customer addUser(Customer user);

	
}

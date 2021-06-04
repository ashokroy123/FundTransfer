package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entity.Beneficiary;
import com.pack.entity.Customer;
import com.pack.repository.CustomerRepository;

@Service
public class CustomerService {

	
	
	@Autowired
	CustomerRepository userRepo;
	

	public Customer getUserByEmail(String email) 
	{
		return userRepo.findByEmail(email);
	}

	public Customer addUser(Customer user) 
	{
		return userRepo.save(user);
	}
	
	public Customer getUserByAccno(Long accno) 
	{
		return userRepo.findByAccno(accno);
	}
	
}

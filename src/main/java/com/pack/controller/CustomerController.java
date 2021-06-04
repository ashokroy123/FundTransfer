package com.pack.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Beneficiary;
import com.pack.entity.Customer;
import com.pack.entity.Login;
import com.pack.entity.TranscationDetails;
import com.pack.entity.Transfer;
import com.pack.exception.BeneficiaryNotFoundException;
import com.pack.exception.DuplicateEntryException;
import com.pack.exception.NoSufficientBalanceException;
import com.pack.exception.UserNotFoundException;
import com.pack.service.BeneficiaryService;
import com.pack.service.CustomerService;
import com.pack.service.TranscationDetailsService;

@RestController
public class CustomerController {

	private static final Logger log = LoggerFactory.getLogger(CustomerController.class.getName());
	
	

	@Autowired
	TranscationDetailsService transcationDetailsService;
	
	  @Autowired 
	  CustomerService customerService;
	 
	  @Autowired 
	  BeneficiaryService beneficiaryService;
	 


	@PostMapping("/users")
	public ResponseEntity<String> addUser(@Valid @RequestBody Customer user) throws DuplicateEntryException {
		String message = "";

		if (getUserByEmail(user.getEmail()) != null) {
			log.error("User already exists");
			throw new DuplicateEntryException("User already exists");
		} else {
			message ="Registered Successfully";
			log.info("User registered successfully");
			customerService.addUser(user);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
	}

	public Customer getUserByEmail(String email) {
		return customerService.getUserByEmail(email);
	}

	@GetMapping("/users/in")
	public ResponseEntity<String> logInUser(@RequestBody Login login) throws UserNotFoundException {
		String message = "";

		Customer cust = getUserByEmail(login.getEmail());

		if (cust == null || !(cust.getPassword().equals(login.getPassword()))) {
			log.error("Invalid Email or Password!!");
			throw new UserNotFoundException("Invalid Email or Password!!");
		} else {
			log.info("Logged in successfully");
			message = cust.getName()+ "\n\nLogIn successfully\n";
			message = message + "Account Number : " + cust.getAccno() +"\nName : " +cust.getName()+ "\nIFSC Code : " + cust.getIfsc()
					+ "\nBranch : " + cust.getBranch() + "\nBalance : " + cust.getBalance();

			return new ResponseEntity<String>(message, HttpStatus.OK);

		}
	}


	@PutMapping("/users/{accno}/funds")
	public ResponseEntity<String> transferFunds(@RequestBody Transfer transfer, @PathVariable Long accno) throws BeneficiaryNotFoundException, NoSufficientBalanceException
	{
		String message="";
		
		Customer FromAcc = getUserByAcno(accno);
		Beneficiary ToAcc = getBeneficiaryByAcno(transfer.getAcno());
		
		if (getBeneficiaryByAcno(ToAcc.getAcno()) == null) {
			log.warn("Can't make transactions to non-beneficiary accounts");
			throw new BeneficiaryNotFoundException("Benifuciary Account not available");
		}else if(FromAcc.getBalance()<transfer.getFunds())
		{
			log.error("Transaction Failed Insufficient balance");
			throw new NoSufficientBalanceException("Transaction Failed Insufficient balance");
		}else
		{	
			FromAcc.setBalance(FromAcc.getBalance()-transfer.getFunds());
			
			ToAcc.setBalance(ToAcc.getBalance()+transfer.getFunds());
			
			LocalDateTime timestamp = LocalDateTime.now();
			
			log.info("Transcation successfully");
			
			message="FundTransfer has been successed"+"\n\nCurrent Balance : "+FromAcc.getBalance();
			
			TranscationDetails transcation=new TranscationDetails();
			transcation.setAccno(FromAcc.getAccno());
			transcation.setIfsc(FromAcc.getIfsc());
			transcation.setFunds(transfer.getFunds());
			transcation.setTime(timestamp);
			
			transcationDetailsService.addTranscation(transcation);
			
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
	}
	
	
	
	public Beneficiary getBeneficiaryByAcno(Long acno) {
		return beneficiaryService.getBeneficiaryByAcno(acno);
	}

	public Customer getUserByAcno(Long accno) {
		return customerService.getUserByAccno(accno);
	}

	
}

package com.pack.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

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

@AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CustomerControllerTest {

	@Mock
	CustomerService customerService;

	@InjectMocks
	CustomerController customerController;

	@Mock
	TranscationDetailsService transcationDetailsService;

	@Mock
	BeneficiaryService beneficiaryService;

	private @Valid Customer user;

	@Test
	@DisplayName("Login : Positive Test case")
	void testLogCustomer() throws UserNotFoundException {

		Login login = new Login("Arjun@gmail.com", "Arjun@1234");

		Customer customer = new Customer();
		customer.setAccno(1080451478L);
		customer.setName("Arjun");
		customer.setPhone("9490563467");
		customer.setCity("Nellore");
		customer.setEmail("Arjun@gmail.com");
		customer.setPassword("Arjun@1234");
		customer.setBank("SBI");
		customer.setBranch("podhalakur");

		when(customerService.getUserByEmail(login.getEmail())).thenReturn(customer);

		ResponseEntity<String> loginCustomer = customerController.logInUser(login);

		// assertEquals(true, loginCustomer);
		assertTrue(loginCustomer.getStatusCodeValue() == 200);

	}

	@Test
	@DisplayName("Registration : Positive scenario")
	void testAddCustomer() throws DuplicateEntryException {
		Customer user = new Customer();
		user.setAccno(1080451457L);
		user.setName("kohli");
		user.setPhone("9490563789");
		user.setCity("Nellore");
		user.setEmail("kohli@gmail.com");
		user.setPassword("Arjun@1234");
		user.setBank("SBI");
		user.setBranch("podhalakur");

		when(customerService.getUserByEmail(user.getEmail())).thenReturn(null);

		when(customerService.addUser(user)).thenReturn(user);

		ResponseEntity<String> addUser = customerController.addUser(user);

		assertEquals("Registered Successfully", addUser.getBody());
	}

	@Test

	@DisplayName("Funds Transfer : Positive Scenario")
	void testTransferFunds3() throws NoSufficientBalanceException, BeneficiaryNotFoundException {
		Transfer transfer = new Transfer("Arun", 1957382567L, "AX0000500", 100.0);
		List<Beneficiary> beneficiaries = new ArrayList<>();

		Customer customer = new Customer();

		customer.setAccno(1080451411L);
		customer.setName("ram");
		customer.setPhone("7382593378");
		customer.setCity("Nellore");
		customer.setEmail("ram@gmail.com");
		customer.setPassword("783d@1");
		customer.setBank("SBI");
		customer.setIfsc("SBI9567");
		customer.setBalance(10000.0);
		customer.setBranch("podhalakur");

		// Long accno = 1080451411L;
		// Customer sender=customerService.getUserByAccno(customer.getAccno());

		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setBid(1L);
		beneficiary.setAcno(1957382567L);
		beneficiary.setBank("Axis");
		beneficiary.setBranch("Nellore");
		beneficiary.setIfsc("AX0000500");
		beneficiary.setBalance(1200.0);
		beneficiary.setName("Arun");

		beneficiaries.add(beneficiary);
		// Long acno = 19573825618L;
		// Beneficiary
		// receiver=beneficiaryService.getBeneficiaryByAcno(beneficiary.getAcno());
		LocalDateTime timestamp = LocalDateTime.now();

		TranscationDetails transaction = new TranscationDetails();
		transaction.setTxnId(1L);
		transaction.setAccno(customer.getAccno());
		transaction.setIfsc(customer.getIfsc());
		transaction.setFunds(transfer.getFunds());
		transaction.setTime(timestamp);
		System.out.println(transaction.toString());
		when(customerService.getUserByAccno(customer.getAccno())).thenReturn(customer);

		// when(customerService.getAccountByAcno(transfer.getAcno())).thenReturn(Optional.of(receiver));
		when(beneficiaryService.getBeneficiaryByAcno(transfer.getAcno())).thenReturn(beneficiary);
		/*
		 * when(accountService.updateAccount(sender)).thenReturn(sender);
		 * when(accountService.updateAccount(receiver)).thenReturn(receiver);
		 */
		when(transcationDetailsService.addTranscation(transaction)).thenReturn(transaction);

		ResponseEntity<String> transferFunds = customerController.transferFunds(transfer, customer.getAccno());
		assertTrue(transferFunds.getStatusCodeValue() == 200);
	}
	/*
	 * @Test
	 * 
	 * @DisplayName("Funds Transfer : Negative Scenario1") void testTransferFunds()
	 * { Transfer transfer = new Transfer("Arun", 1957382567L, "AX0000500",
	 * 15000.0);
	 * 
	 * Customer customer = new Customer();
	 * 
	 * customer.setAccno(1080451411L); customer.setName("ram");
	 * customer.setPhone("7382593378"); customer.setCity("Nellore");
	 * customer.setEmail("ram@gmail.com"); customer.setPassword("783d@1");
	 * customer.setBank("SBI"); customer.setIfsc("SBI9567");
	 * customer.setBalance(10000.0); customer.setBranch("podhalakur");
	 * 
	 * // Long accno = 1080451411L; // Customer
	 * sender=customerService.getUserByAccno(customer.getAccno());
	 * 
	 * Beneficiary beneficiary = new Beneficiary(); beneficiary.setBid(1L);
	 * beneficiary.setAcno(1957382567L); beneficiary.setBank("Axis");
	 * beneficiary.setBranch("Nellore"); beneficiary.setIfsc("AX0000500");
	 * beneficiary.setBalance(1200.0); beneficiary.setName("Arun");
	 * 
	 * 
	 * when(customerService.getUserByAccno(customer.getAccno())).thenReturn((
	 * customer)); //
	 * when(beneficiaryService.getBeneficiaryByAcno(transfer.getAcno())).thenReturn(
	 * beneficiary); NoSufficientBalanceException e =
	 * assertThrows(NoSufficientBalanceException.class, () ->
	 * customerController.transferFunds(transfer, customer.getAccno()));
	 * 
	 * assertEquals("Transaction Failed Insufficient balance", e.getMessage()); }
	 */
}

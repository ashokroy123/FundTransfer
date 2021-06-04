package com.pack.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

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

import com.pack.entity.Customer;
import com.pack.repository.CustomerRepository;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	CustomerService customerService;

	@Test
	public void getUserByEmailTest() {

		Customer customer = new Customer();

		customer.setName("ram");
		customer.setPhone("7382593378");
		customer.setCity("Nellore");

		customer.setEmail("ajay@gmail.com");

		customer.setPassword("783d@1");
		customer.setBank("SBI");
		customer.setBranch("podhalakur");

		when(customerRepository.findByEmail(customer.getEmail())).thenReturn(customer);

		Customer customerByEmail = customerService.getUserByEmail(customer.getEmail());

		assertTrue(customerByEmail.getAccno() == customer.getAccno());
	}

	@Test
	public void addUserTest() {
		Customer customer = new Customer();
		customer.setAccno(1080451434L);
		customer.setName("ram");
		customer.setPhone("7382593378");
		customer.setCity("Nellore");
		customer.setEmail("ram@gmail.com");
		customer.setPassword("783d@1");
		customer.setBank("SBI");
		customer.setBranch("podhalakur");

		customerService.addUser(customer);

		verify(customerRepository, times(1)).save(customer);

	}

	@Test
	void getUserByAccnoTest() {
		Customer customer = new Customer();
		customer.setAccno(1080451415L);

		customer.setName("abhi");
		customer.setPhone("7538927367");
		customer.setCity("Nellore");
		customer.setEmail("abhi@gmail.com");
		customer.setPassword("156456");
		customer.setBranch("Hyderabad");

		when(customerRepository.findByAccno(customer.getAccno())).thenReturn(customer);

		Customer customerByAcc = customerService.getUserByAccno(customer.getAccno());
		//assertTrue(customerByAcc.isPresent());
		assertTrue(customerByAcc.getEmail() == customer.getEmail());
	}

}

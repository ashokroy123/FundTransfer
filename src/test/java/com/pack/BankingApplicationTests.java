package com.pack;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankingApplicationTests {
	
	@Test
	void test() {
		
	}
	/*
	 * @InjectMocks CustomerService customerService;
	 * 
	 * @Mock CustomerRepository customerRepository;;
	 * 
	 * @InjectMocks CustomerController customerController;
	 * 
	 * private Customer customer;
	 * 
	 * @Test public void getUserByEmailTest() {
	 * 
	 * Customer customer = new Customer(); customer.setName("ram");
	 * customer.setPhone("7382593378"); customer.setCity("Nellore");
	 * customer.setEmail("ram@gmail.com"); customer.setPassword("783d@1");
	 * customer.setBank("SBI"); customer.setBranch("podhalakur");
	 * 
	 * 
	 * when(customerRepository.findByEmail(customer.getEmail())).thenReturn(customer
	 * );
	 * 
	 * Customer customerByEmail =
	 * customerService.getUserByEmail(customer.getEmail());
	 * 
	 * 
	 * assertTrue(customerByEmail.getAccno()==customer.getAccno());
	 * 
	 * 
	 * 
	 * when(customerRepository.findByEmail("anil@gmail.com ")).thenReturn(new
	 * Customer(108045141000L, "7538927654", "SBI", "chennai", "alluru ",
	 * "anil@gmail.com", "HCLIN005917", "anil", "675656", 9000d));
	 * 
	 * Customer cust = customerService.getUserByEmail("anil@gmail.com ");
	 * assertEquals(108045141000, cust.getAccno()); assertEquals("anil",
	 * cust.getName()); assertEquals("7538927654", cust.getPhone());
	 * assertEquals("chennai", cust.getCity());
	 * 
	 * assertEquals("675656", cust.getPassword()); assertEquals("SBI",
	 * cust.getBank()); assertEquals("HCLIN005917", cust.getIfsc());
	 * assertEquals("alluru", cust.getBranch()); assertEquals("9000d",
	 * cust.getBalance());
	 * 
	 * }
	 * 
	 * @Test public void addUserTest() { Customer customer = new Customer();
	 * customer.setName("ram"); customer.setPhone("7382593378");
	 * customer.setCity("Nellore"); customer.setEmail("ram@gmail.com");
	 * customer.setPassword("783d@1"); customer.setBank("SBI");
	 * customer.setBranch("podhalakur");
	 * 
	 * customerService.addUser(customer);
	 * 
	 * verify(customerRepository, times(1)).save(customer);
	 * 
	 * }
	 */
}

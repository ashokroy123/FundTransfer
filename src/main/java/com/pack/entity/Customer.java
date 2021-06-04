package com.pack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name="accno_generator", initialValue=1080451410, allocationSize=1)
public class Customer {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="accno_generator")
	private Long accno;
	
	@Column
	private String name;
	
	@Column
	@Size(min=10, max = 10)
	private String phone;

	@Column
	private String city;
	
	@Column
	@Email
	private String email;
	
	@Column
	@Size(min = 6, max=15)
	private String password;
	
	@Column(columnDefinition = "varchar(50) default 'ROYAL BANK'",insertable = false)
	private String bank;
	
	@Column(columnDefinition = "varchar(50) default 'HCLIN005917'",insertable = false)
	private String ifsc;
	
	@Column
	private String branch;
	
	@Column(columnDefinition = "double default '10000.00'",insertable = false)
	private Double balance;

	public Customer() {
		super();
	}

	
	public Customer(Long accno, String name, @Size(min = 10, max = 10) String phone, String city, @Email String email,
			@Size(min = 6, max = 15) String password, String bank, String ifsc, String branch, Double balance) {
		super();
		this.accno = accno;
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.email = email;
		this.password = password;
		this.bank = bank;
		this.ifsc = ifsc;
		this.branch = branch;
		this.balance = balance;
	}


	public Long getAccno() {
		return accno;
	}

	public void setAccno(Long accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [accno=" + accno + ", name=" + name + ", phone=" + phone + ", city=" + city + ", email=" + email
				+ ", password=" + password + ", bank=" + bank + ", ifsc=" + ifsc + ", branch=" + branch + ", balance="
				+ balance + "]";
	}


	public Customer get() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}


	

	
}

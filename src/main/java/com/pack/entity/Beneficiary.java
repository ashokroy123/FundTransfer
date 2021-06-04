package com.pack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="bid_generator", initialValue=101, allocationSize=1)
public class Beneficiary {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bid_generator")
	private Long bid;
	
	
	@Column
	private Long acno;
	
	
	@Column
	private String ifsc;
	
	@Column
	private String branch;
	
	@Column
	private String bank;
	
	@Column
	private String name;
	
	@Column(columnDefinition = "double default '0.00'",insertable = false)
	private Double balance;

	

	public Beneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Beneficiary(Long bid, Long acno, String ifsc, String branch, String bank, String name, Double balance) {
		super();
		this.bid = bid;
		this.acno = acno;
		this.ifsc = ifsc;
		this.branch = branch;
		this.bank = bank;
		this.name = name;
		this.balance = balance;
	}



	public Long getBid() {
		return bid;
	}



	public void setBid(Long bid) {
		this.bid = bid;
	}



	public Long getAcno() {
		return acno;
	}



	public void setAcno(Long acno) {
		this.acno = acno;
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



	public String getBank() {
		return bank;
	}



	public void setBank(String bank) {
		this.bank = bank;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Double getBalance() {
		return balance;
	}



	public void setBalance(Double balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "Beneficiary [bid=" + bid + ", acno=" + acno + ", ifsc=" + ifsc + ", branch=" + branch + ", bank=" + bank
				+ ", name=" + name + ", balance=" + balance + "]";
	}



	public Beneficiary getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

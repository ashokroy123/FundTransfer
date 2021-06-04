package com.pack.entity;

public class Transfer {

	
	
	private String name;
	private Long acno;
	private String ifsc;
	private Double funds; 
	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transfer(String name, Long acno, String ifsc, Double funds) {
		super();
		this.name = name;
		this.acno = acno;
		this.ifsc = ifsc;
		this.funds = funds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Double getFunds() {
		return funds;
	}
	public void setFunds(Double funds) {
		this.funds = funds;
	}
	@Override
	public String toString() {
		return "Transfer [name=" + name + ", acno=" + acno + ", ifsc=" + ifsc + ", funds=" + funds + "]";
	}
	
	
}

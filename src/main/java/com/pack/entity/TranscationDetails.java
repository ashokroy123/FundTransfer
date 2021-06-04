package com.pack.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TranscationDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long txnId;
	private Long accno;
	private String ifsc;
	private Double funds;
	private LocalDateTime time;
	
	
	
	public TranscationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TranscationDetails(Long txnId, Long accno, String ifsc, Double funds, LocalDateTime time) {
		super();
		this.txnId = txnId;
		this.accno = accno;
		this.ifsc = ifsc;
		this.funds = funds;
		this.time = time;
	}


	public Long getTxnId() {
		return txnId;
	}


	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}


	public Long getAccno() {
		return accno;
	}


	public void setAccno(Long accno) {
		this.accno = accno;
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


	public LocalDateTime getTime() {
		return time;
	}


	public void setTime(LocalDateTime time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "TranscationDetails [txnId=" + txnId + ", accno=" + accno + ", ifsc=" + ifsc + ", funds=" + funds
				+ ", time=" + time + "]";
	}


	
	

	

	
	
	
}

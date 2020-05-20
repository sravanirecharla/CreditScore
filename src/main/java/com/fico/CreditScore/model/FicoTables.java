package com.fico.CreditScore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class FicoTables {
	@Id
	@GeneratedValue
	@NotNull
	private int transactionNumber;
	@NotNull
	
	private Long creditCardNumber;
	@NotNull
	@Size(min=300, max=850, message = "fico score should be in range of 300 to 850")
	private int ficoScore;
	
	public FicoTables(int transactionNumber, Long creditCardNumber, int ficoScore) {
		super();
		this.transactionNumber = transactionNumber;
		this.creditCardNumber = creditCardNumber;
		this.ficoScore =ficoScore;
	}
	public FicoTables() {
	}
	
	public int getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public Long getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public int getFicoScore() {
		return ficoScore;
	}
	public void setFicoScore(int ficoScore) {
		this.ficoScore = ficoScore;
	}
	
		
}

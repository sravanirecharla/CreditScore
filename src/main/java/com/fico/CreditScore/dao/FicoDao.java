package com.fico.CreditScore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fico.CreditScore.model.FicoTables;


@Repository
public interface FicoDao extends JpaRepository<FicoTables, Integer>{
	
	public FicoTables findBytransactionNumber(int transactionNumber);

	public int deleteByTransactionNumber(int transactionNumber);

}

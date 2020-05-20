package com.fico.CreditScore.Controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fico.CreditScore.api.FicoCreditScoreAPI;
import com.fico.CreditScore.dao.FicoDao;
import com.fico.CreditScore.model.FicoTables;
import com.fico.CreditScore.validation.Validations;

@RestController
public class FicoScoreController implements FicoCreditScoreAPI {

	@Autowired
	private FicoDao ficoDao;

	private static final Logger log = LoggerFactory.getLogger(FicoScoreController.class);

	@Override
	public ResponseEntity<?> ping() {
		HashMap<String, String> obj = new HashMap<>();
		obj.put("status", "ping success");
		log.info("endpoint has been hit");
		return ResponseEntity.ok(obj);

	}

	@Override
	public FicoTables postFicoScore(@Valid @RequestBody FicoTables ficoTables) {
		return ficoDao.save(ficoTables);

	}

	@Override
	public FicoTables getFicoScore(@PathVariable int transaction_id) {
		return ficoDao.findBytransactionNumber(transaction_id);
	}

	@Override
	@Transactional
	public void deleteFicoScore(@PathVariable int transactionNumber) {
		int a = ficoDao.deleteByTransactionNumber(transactionNumber);
		// ficoDao.deleteById(id);
		HashMap<String, String> obj = new HashMap<>();
		obj.put("status", "rec deleted");
	}

	@Override
	public FicoTables putFicoScore(@RequestBody FicoTables ficoTables, @PathVariable int transactionNumber) {
		
		return ficoDao.findById(transactionNumber)
			      .map(employee -> {
			        employee.setCreditCardNumber(ficoTables.getCreditCardNumber());
			        employee.setFicoScore(ficoTables.getFicoScore());
			        return ficoDao.save(employee);
			      })
			      .orElseGet(() -> {
			    	  ficoTables.setTransactionNumber(transactionNumber);
			        return ficoDao.save(ficoTables);
			      });
		
		

	}

}

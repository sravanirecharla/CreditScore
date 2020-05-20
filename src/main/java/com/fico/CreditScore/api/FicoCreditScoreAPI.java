package com.fico.CreditScore.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fico.CreditScore.model.FicoTables;

@RequestMapping("/getScore")
public interface FicoCreditScoreAPI {
	
	
	@GetMapping("/ping")
	@ResponseBody
	public ResponseEntity<?> ping() ;
	
	@GetMapping("/getData/{transaction_id}")
	public FicoTables getFicoScore(@PathVariable int transaction_id);
	
	@PostMapping("/insertData")
	public FicoTables postFicoScore(@Valid @RequestBody FicoTables ficoTables) ;
	
//	@PutMapping("/employees/{id}")
//	public FicoTables putFicoScore(@RequestBody FicoTables ficoTables, @PathVariable int id) ;
	
	@PutMapping("/updateData/{transactionNumber}")
	public FicoTables putFicoScore(@Valid @RequestBody FicoTables ficoTables, @PathVariable int transactionNumber) ;

	@DeleteMapping("/deleteData/{transactionNumber}")
	public void deleteFicoScore(@PathVariable int transactionNumber) ;

}

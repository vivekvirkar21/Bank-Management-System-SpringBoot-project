package springBoot.bank_Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;

import springBoot.bank_Project.model.Account;
import springBoot.bank_Project.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAll(){
		return new ResponseEntity<>(service.getAllAccount(),HttpStatus.OK);
	}
	
	
	@GetMapping("/accounts/{accNo}")
	public ResponseEntity<Account> getByAccNo(@PathVariable long accNo){
		Account account = service.getByAccNo(accNo);
		
		if(account != null) {
			return new ResponseEntity<>(account,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/account")
	public ResponseEntity<?> addAccount(@RequestBody Account account){
		try {
			Account acc = service.addAccount(account);
			return new ResponseEntity<>(acc,HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
}

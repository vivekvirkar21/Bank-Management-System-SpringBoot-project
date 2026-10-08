package springBoot.bank_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.bank_Project.model.Account;
import springBoot.bank_Project.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repo;

	public List<Account> getAllAccount() {
		return repo.findAll();
	}

	public Account getByAccNo(long accNo) {
		return repo.findByAccNo(accNo);
	}

	public Account addAccount(Account account) {
		return repo.save(account);
	}
	
	
}

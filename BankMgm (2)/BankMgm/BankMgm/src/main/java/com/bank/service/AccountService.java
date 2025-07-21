package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exceptions.AccountDoesNotExist;
import com.bank.model.AccountHolder;
import com.bank.repo.AccountHolderRepo;

@Service
public class AccountService implements BankServices
{
	@Autowired
	AccountHolderRepo repo;
	
	@Override
	public List<AccountHolder> addAccount(AccountHolder account) 
	{
		try 
		{
			repo.save(account);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return repo.findAll();
		
	}

	@Override
	public List<AccountHolder> getAccounts() 
	{
		
		return repo.findAll();
	}

	@Override
	public List<AccountHolder> updateAccount(float amount, int id) 
	{

		if(repo.findById(id).isPresent()==false)
		{
			return null;
		}
		else
		{
			AccountHolder account = repo.findById(id).get();
			
			float cur_balance= account.getBalance();
			
			account.setBalance(cur_balance+=amount);
			
			repo.save(account);
			return repo.findAll(); 
		}
	 }

	@Override
	public List<AccountHolder> deleteAccount(int id) 
	{
		if(repo.findById(id).isPresent()==false)
		{
			throw new AccountDoesNotExist("Account does not exists with  id " +id);
		}
		else
		{
			repo.deleteById(id);
			return repo.findAll(); 
		}
	}

	@Override
	public List<AccountHolder> getByName(String fname) 
	{
		return repo.findByFname(fname);
	}

	@Override
	public List<AccountHolder> getByFnameAndId(String fname, int id) 
	{
		
		return repo.findByFnameAndAccountNo(fname,id);
	}
	

	
	
	
}

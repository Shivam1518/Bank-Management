package com.bank.service;

import java.util.List;

import com.bank.model.AccountHolder;

public interface BankServices 
{
	public List<AccountHolder> addAccount(AccountHolder account);

	public List<AccountHolder> getAccounts();

	public List<AccountHolder> updateAccount(float amount, int id);

	public List<AccountHolder> deleteAccount(int id);

	public List<AccountHolder> getByName(String fname);

	public List<AccountHolder> getByFnameAndId(String fname, int id);

	

}
 
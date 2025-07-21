package com.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder, Integer>
{

	public List<AccountHolder> findByFname(String fname);

	public List<AccountHolder> findByFnameAndAccountNo(String fname, int id);
	

}

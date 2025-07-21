package com.bank.exceptions;

public class AccountDoesNotExist extends RuntimeException
{
	public AccountDoesNotExist(String msg)
	{
		super(msg);
	}
	
}

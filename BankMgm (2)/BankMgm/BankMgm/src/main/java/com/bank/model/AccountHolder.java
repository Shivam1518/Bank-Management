package com.bank.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.PostPersist;
//import jakarta.persistence.PostUpdate;
//import jakarta.persistence.PrePersist;
//import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class AccountHolder 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int accountNo;
	
	@Column
	@NotBlank(message = "First name cannot be blank")
	private String fname;
	
	@Column
	@NotBlank(message = "Last name cannot be blank")
	private String lname;
	
	@Column
	@Email(message ="Enter a valid email address")
	@NotBlank
	private String email;
	
	@Column
	@Pattern(regexp = "(\\+91)?[6-9][0-9]{9}",message = "Enter a valid phone number")
	private String phone;
	
	@Column
	@Min(value =0, message ="Min balanec must be zero")
	private float balance;
	
	@CreationTimestamp
	private Date createdDate; 
	
	@UpdateTimestamp
	private Date updatedDate; 
	
	


	public AccountHolder(int accountNo, @NotBlank(message = "First name cannot be blank") String fname,
			@NotBlank(message = "Last name cannot be blank") String lname,
			@Email(message = "Enter a valid email address") @NotBlank String email,
			@Pattern(regexp = "(\\+91)?[6-9][0-9]{9}", message = "Enter a valid phone number") String phone,
			@Min(value = 0, message = "Min balanec must be zero") float balance, Date createdDate, Date updatedDate) 
	{
		super();
		this.accountNo = accountNo;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}


	public AccountHolder() 
	{
		super();
		
	}


	public int getAccountNo() 
	{
		return accountNo;
	}


	public void setAccountNo(int accountNo) 
	{
		this.accountNo = accountNo;
	}


	public String getFname() 
	{
		return fname;
	}


	public void setFname(String fname) 
	{
		this.fname = fname;
	}


	public String getLname() 
	{
		return lname;
	}


	public void setLname(String lname) 
	{
		this.lname = lname;
	}


	public String getEmail() 
	{
		return email;
	}


	public void setEmail(String email) 
	{
		this.email = email;
	}


	public String getPhone() 
	{
		return phone;
	}


	public void setPhone(String phone) 
	{
		this.phone = phone;
	}


	public float getBalance() 
	{
		return balance;
	}


	public void setBalance(float balance) 
	{
		this.balance = balance;
	}
	
		
	
	public Date getCreatedDate() 
	{
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) 
	{
		this.createdDate = createdDate;
	}


	public Date getUpdatedDate() 
	{
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) 
	{
		this.updatedDate = updatedDate;
	}


	
	
	
	
//	
//	@PrePersist()
//	public void beforeSave()
//	{
//		System.out.println("Before save....................");
//	}
//	
//	
//	@PostPersist()
//	public void afterSave()
//	{
//		System.out.println("After save....................");
//	}
//	
//	@PreUpdate()
//	public void beforeUpdate()
//	{
//		System.out.println("Before update....................");
//	}
	
//	@PostUpdate()
//	public void afterUpdate()
//	{
//		System.out.println("After update...................");
//	}
//	
	

}

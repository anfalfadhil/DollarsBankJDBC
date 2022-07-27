package com.dollarsbank.model;
import java.util.List;



public class Customer {
	
	private int id;
	private String name;
	private String address;
	private String phone;
	private String password;
	private float balance;
	private List<Transaction> transaction;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Customer(int id, String name, String address, String phone, String password, float balance,
			List<Transaction> transaction) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.password = password;
		this.balance = balance;
		this.transaction = transaction;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}


	public List<Transaction> getTransaction() {
		return transaction;
	}


	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	
	
	

}

package com.dollarsbank.model;

import java.time.LocalDate;

public class Transaction {

	private int id;
	private LocalDate date;
	private float amount;
	private Customer customer;

	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int id, LocalDate date, float amount, Customer customer) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.customer = customer;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	
	
	
	
}

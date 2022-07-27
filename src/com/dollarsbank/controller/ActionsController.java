package com.dollarsbank.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.dollarsbank.connection.ConnectionManager;

public class ActionsController {
	
	private static Scanner sc = new Scanner(System.in);
	private static Connection conn = ConnectionManager.getConnection();
	
	
	public static void deposit() throws SQLException {
		String user_phone = LoginController.phone;
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customer WHERE phone = ? ");
		pstmt.setString(1, user_phone);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		float db_balance = rs.getFloat("balance");
		
		
	    System.out.println("Enter the Amount you want to deposit: ");
	    float deposit = Float.parseFloat(sc.next());
		
		
		float new_balance = db_balance + deposit;
		
		
		PreparedStatement pstmt2 = conn.prepareStatement("UPDATE customer SET balance= ? where phone = ? ");
		pstmt2.setFloat(1, new_balance);
		pstmt2.setString(2, user_phone);
		int i = pstmt2.executeUpdate();

		System.out.println("Your deposit was successful, your current balance is: " + new_balance);
		
	}
	
	
	
	
	public static void withdraw() throws SQLException {
		String user_phone = LoginController.phone;
		PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM customer WHERE phone = ? ");
		pstmt1.setString(1, user_phone);
		ResultSet rs1 = pstmt1.executeQuery();
		rs1.next();
		float db_balance = rs1.getFloat("balance");
		
	    System.out.println("How Much DO You Want to Withdraw? ");
	    float withdraw = Float.parseFloat(sc.next());
	    
	    
	    if (withdraw > db_balance) {
	    	System.out.println("this aount is less than your balance, unable to complete this transaction");
	    }else if (withdraw <= db_balance ){
	    	float new_balance = db_balance - withdraw;
			PreparedStatement pstmt2 = conn.prepareStatement("UPDATE customer SET balance= ? where phone = ? ");
			pstmt2.setFloat(1, new_balance);
			pstmt2.setString(2, user_phone);
			int i = pstmt2.executeUpdate();

			System.out.println("Your transaction was successful, your current balance is: " + new_balance);
	    	
	    }
		
	}
	
	
	
	public static void transfer() throws SQLException {
		String user_phone = LoginController.phone;
		PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM customer WHERE phone = ? ");
		pstmt1.setString(1, user_phone);
		ResultSet rs1 = pstmt1.executeQuery();
		rs1.next();
		float my_balance = rs1.getFloat("balance");
		
		System.out.println("Enter the phone number for the person you want to transfer funds to : ");
	    String phone2 = sc.next();
		PreparedStatement pstmt2 = conn.prepareStatement("SELECT * FROM customer WHERE phone = ? ");
		pstmt2.setString(1, phone2);
		ResultSet rs2 = pstmt2.executeQuery();
		rs2.next();
		float their_balance = rs2.getFloat("balance");
		
		
	    System.out.println("Enter the amount you want to transfer: ");
	    float trans = Float.parseFloat(sc.next());
	    
	    float my_new_balance = my_balance - trans;
	    float their_new_balance = their_balance + trans;
	    
	    
	    
	    PreparedStatement pstmt3 = conn.prepareStatement("UPDATE customer SET balance= ? where phone = ? ");
		pstmt3.setFloat(1, my_new_balance);
		pstmt3.setString(2, user_phone);
		int i = pstmt3.executeUpdate();
		
	    PreparedStatement pstmt4 = conn.prepareStatement("UPDATE customer SET balance= ? where phone = ? ");
		pstmt4.setFloat(1, their_new_balance);
		pstmt4.setString(2, phone2);
		int i2 = pstmt4.executeUpdate();
	    
		System.out.println("Your transaction was successful, your current balance is: " + my_new_balance + "\n"
				+ "their new balance is: " + their_new_balance);
	    
	}
	
	
	
	public static void display_info() throws SQLException {
		String user_phone = LoginController.phone;
		PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM customer WHERE phone = ? ");
		pstmt1.setString(1, user_phone);
		ResultSet rs1 = pstmt1.executeQuery();
		rs1.next();
		String name = rs1.getString("name");
		String phone = rs1.getString("phone");
		String address = rs1.getString("address");
		String password = rs1.getString("password");
		float balance = rs1.getFloat("balance");
		
		System.out.println("Name: " + name + "\n"
				+ "Phone: " + phone + "\n"
						+ "Address: " + address + "\n"
								+ "Password: " + password + "\n"
										+ "Balance: " + balance );
	}
	
	
	
	
	

}

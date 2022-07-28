package com.dollarsbank.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.dollarsbank.connection.ConnectionManager;
import com.dollarsbank.exception.GlobalExceptionHandler;
import com.dollarsbank.model.Customer;

public class LoginController {
	
	private static Scanner sc = new Scanner(System.in);
	private static Connection conn = ConnectionManager.getConnection();
	private static String name;
	private static String password;
	private static String address;
	public static String phone;
	private static float balance;
	public static int choise;
	
	public static void signUp() {
		try {
			
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO customer(name, address, phone, password, balance) VALUES(?,?,?,?,?)");
			
			
			System.out.println("\nFull Name: ");
			name = sc.nextLine();
			pstmt.setString(1, name);
			
			
			System.out.println("\nAddress: ");
			address = sc.nextLine();
			pstmt.setString(2, address);
			
			System.out.println("\nPhone Number: ");
			phone = sc.nextLine();
			pstmt.setString(3, phone);
			
			System.out.println("Password: ");
			password = sc.nextLine();
			pstmt.setString(4, password);
			
			
			System.out.println("Initial Deposit Amount: ");
			balance = sc.nextFloat();
			pstmt.setFloat(5, balance);
			
			
			int count = pstmt.executeUpdate();
			
			if(count > 0 ) {
				System.out.println("\nSuccussfully signed up!!\n");
				//menu2();
			} else {
				System.out.println("\nUnable to sign up\n");
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("Unable to complete sign up");
			e.printStackTrace();
		}
	
	
	
	}
	
	
	
	public static void actionsList() {
		
	}
	
	public static void login() throws SQLException {
		
		try {
			
		
		
	    System.out.println("Please Enter your Phone Number : ");
	     phone = sc.next();
	    
	    System.out.println("Please Enter your Password : ");
	     password = sc.next();
	    
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customer WHERE phone = ? ");
		
		pstmt.setString(1, phone);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		String db_phone = rs.getString("phone");
		String db_password = rs.getString("password");
		
		if (phone.equals(db_phone) && password.equals(db_password)) {
			System.out.println("Welcome! What can I do for you? ");
			System.out.println("1. Deposite Amount\n"
					+ "2. Withdraw Amount\n"
					+ "3. Display Customer Information\n"
					+ "4. Funds Transfer\n"
					+ "5. Show last five transactions\n"
					+ "6. Sign Out");
			
			choise = Integer. parseInt(sc.next());
			
			switch (choise) {
			case 1: 
				ActionsController.deposit();
				break;
			case 2: 
				ActionsController.withdraw();
				break;
			case 3: 
				ActionsController.display_info();
				break;
			case 4: 
				ActionsController.transfer();
				break;
			case 5: 
				ActionsController.display5transactions();
				break;
			case 6: 
				logout();
				break;
			default:
				throw new GlobalExceptionHandler("you must choose on of the listed numbers, invalid input");
			}
		
		
			
			
		}
		
		} catch ( GlobalExceptionHandler gex) {
			System.out.println(gex.getMessage());
		}
	    
	}
	
	
	
	
	public static void logout() {
		System.out.println("Thank you for your Business, see you soon!");
		LoginController.phone= "N/A";
	}
	
	
	public static int current_user_id() throws SQLException {
		String phone = LoginController.phone;
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customer WHERE phone = ? ");	
		pstmt.setString(1, phone);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		int customerid = rs.getInt("id");
		return customerid;
		
	}
	
	
	
	

}

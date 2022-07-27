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
		
		System.out.println("Your deposit was successful, your current balance is: " + new_balance);
		
	}

}

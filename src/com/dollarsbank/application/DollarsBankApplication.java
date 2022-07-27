package com.dollarsbank.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.dollarsbank.connection.ConnectionManager;
import com.dollarsbank.controller.LoginController;



public class DollarsBankApplication {

	
	
	public static void main ( String args[]) throws Throwable  {

		Scanner scan = new Scanner(System.in);
		
		Connection conn = ConnectionManager.getConnection();
		//System.out.println("MySQL D/B connection established :) ");
		
		System.out.println("WELCOME TO DOLLARSBANK");
		System.out.println("Please choose on of the follwoing options: ");
		System.out.println("1. Create New Account \n"
				+ "2. Login \n"
				+ "3. Exit");
		LoginController login = new LoginController();
		
		int customer_choice = scan.nextInt();
		
		if (customer_choice == 1) {
			
			login.signUp();
		} else if ( customer_choice == 2) {
			login.login();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		try {
//			conn.close();
//			System.out.println("Did close the connection successfuly :)");
//			
//
//			
//		} catch (SQLException e) {
//			System.out.println("Did not close the connection");
//		
//			e.printStackTrace();
//		}
//		
		
		
		
		

		
		
		
		
	}
	
	
	
	
	
	
}

package com.cdw.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cdw.dao.TransactionDAO;
import com.cdw.model.Transaction;

public class TransactionRunner extends Main {

	private static Scanner scan = new Scanner(System.in);
	
	
	//1
	public void tranByZip() {
		try {
			System.out.print("Enter a Zipcode: ");
			String zip = scan.next();
			System.out.print("Enter a Month: ");
			String month = scan.next();
			System.out.print("Enter a Year: ");
			String year = scan.next();
			System.out.println();
			
			//TEST DATA		Zip: 39120 Month: 9 Year: 2018
			TransactionDAO tDAO = new TransactionDAO();
			ArrayList<Transaction> tran = tDAO.getTranByZip(zip, Integer.parseInt(month), Integer.parseInt(year));
			for (Transaction n : tran) {
				System.out.println("ID: " + n.getTranID());
				System.out.println("Day: " + n.getDay());
				System.out.println("Month: " + n.getMonth());
				System.out.println("Year: " + n.getYear());
				System.out.println("Credit NO: " + n.getCreditNo());
				System.out.println("SSN: " + n.getSsn());
				System.out.println("Branch Code: " + n.getBranchCode());
				System.out.println("Transaction Type: " + n.getTranType());
				System.out.println("Transaction Value: " + n.getTranVal());
				System.out.println();
				
				output += n.getTranID() + del + n.getDay() + del + n.getMonth() + del + n.getYear() + del + n.getCreditNo() + del + n.getSsn() + del + n.getBranchCode() 
					+ del + n.getTranType() + del + n.getTranVal() + "\n";
			}
			header1 += "Zip: " + zip + headDel + "Month: " + month + headDel + "Year: " + year;
			header2 += "ID" + del + "Day" + del + "Month" + del + "Year" + del + "CreditNO" + del + "SSN" + del + "Branch Code" + del + "Type" + del + "Value";
			export();
		} catch (java.lang.Exception e) {
			System.out.println("NO DATA.");
		}
	}
	
	
	
	//2
	public void tranSumByTranType() {
		try {
			System.out.print("Enter a Transaction Type: ");
			String type = scan.next();
			System.out.println();
			
			//TEST DATA		Type: Gas
			TransactionDAO tDAO = new TransactionDAO();
			Transaction tran = tDAO.getTranSumByTranType(type);
			System.out.println("Number of Transactions: " + tran.getCount());
			System.out.println("Total Value: " + tran.getTranVal());
			System.out.println();
			
			output += tran.getCount() + del + tran.getTranVal();
			header1 += "Type: " + type;
			header2 += "Transaction Count" + del + "Value";
			export();
		} catch (java.lang.Exception e) {
			System.out.println("NO DATA.");
		}
	}
	
	
	
	//3
	public void tranSumByState() throws IOException {
		System.out.print("Enter a State Abbreviation: ");
		String state = scan.next().toUpperCase();
		System.out.println();
		
		//TEST DATA		State: IL,il
		TransactionDAO tDAO = new TransactionDAO();
		ArrayList<Transaction> tran = tDAO.getTranSumByState(state);
		for (Transaction n : tran) {
			System.out.println("Bank Name: " + n.getTranType());
			System.out.println("Number of Transactions: " + n.getCount());
			System.out.println("Total Value: " + n.getTranVal());
			System.out.println();
			
			output += n.getTranType() + del + n.getCount() + del + n.getTranVal() + "\n";
		}
		header1 += "State: " + state.toUpperCase();
		header2 += "Bank Name" + del + "Transaction Count" + del + "Total Value"; 
		export();
	}
	
}//end of class


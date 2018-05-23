package com.cdw.runner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Main {
	
	private static Scanner scan = new Scanner(System.in);
	private static String sel = null;
	
	public static void main(String[] args) throws IOException  {
		while (true) {
			CustomerRunner cr = new CustomerRunner();
			TransactionRunner tr = new TransactionRunner();
			
			System.out.println("ACTIONS AVAILABLE:");
			//1.1.1
			System.out.println("1. Display the transactions made by customers living in a given zipcode for a given month and year.");
			System.out.println("2. Display the number and total value of transactions for a given type.");
			System.out.println("3. Display the number and total value of transactions for branches in a given state.");
			//1.1.2
			System.out.println("4. Display the existing account details of a customer.");
			System.out.println("5. Modify the existing account details of a customer.");
			System.out.println("6. Generate monthly bill for a credit card number for a given month and year.");
			System.out.println("7. Display the transactions made by a customer between two dates.");
			System.out.println();
			System.out.print("SELECT AN ACTION. ENTER '0' TO QUIT: ");
			sel = scan.next();
			
			
			switch (sel) {
			case "0":
				System.out.println("GOODBYE.");
				scan.close();
				System.exit(0);
			case "1":
				tr.tranByZip();
				break;
			case "2":
				tr.tranSumByTranType();
				break;
			case "3":
				tr.tranSumByState();
				break;
			case "4":
				cr.customerBySSN();
				break;
			case "5":
				cr.modifyCustomer();
				break;
			case "6":
				cr.billByDate();
				break;
			case "7":
				cr.sumByDate();
				break;
			default :
				System.out.println("NOT AN ACTION.");
			}
	
			
			System.out.println();
			System.out.println();
		}//end of while loop
	}
	
	
	
	//export of .csv file
	String header1 = ""; String header2 = ""; String output = ""; 
	final String headDel = "   "; final String del = ",";
	public void export() throws IOException {
		System.out.print("EXPORT TO CSV FILE? (y/n): ");
		if (scan.next().toLowerCase().equals("y")) {
			Date date = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy_hh-mm-ss");
			String filename = "output_" + dateformat.format(date) + ".csv";
			
			String header = "USER INPUTED VALUES" + headDel +  "ACTION: " + sel;
			FileWriter fw = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(header + "\n" + header1 + "\n" + header2 + "\n" + output); 
			bw.close();
			System.out.println("FILE EXPORTED.");
		}
	}
}
package com.cdw.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.cdw.model.Customer;
import com.cdw.model.Transaction;
import com.cdw.resources.Queries;

public class CustomerDAO extends AbstractDAO {
	Customer customer = null;

	
	//4
	public ArrayList<Customer> getCustomerBySSN (int ssn){
		ArrayList<Customer> temp = new ArrayList<>();
		establishConnection();
		String query = Queries.GET_CUST_BY_SSN;
		try {
			state = conn.prepareStatement(query);
			state.setInt(1, ssn);
			result = state.executeQuery();
			
			while (result.next()){
				customer = new Customer();
				customer.setfName(result.getString(1));
				customer.setmName(result.getString(2));
				customer.setlName(result.getString(3));
				customer.setSsn(result.getInt(4));
				customer.setCreditNo(result.getString(5));
				customer.setAptNo(result.getString(6));
				customer.setStreet(result.getString(7));
				customer.setCity(result.getString(8));
				customer.setState(result.getString(9));
				customer.setCountry(result.getString(10));
				customer.setZip(result.getString(11));
				customer.setPhone(result.getInt(12));
				customer.setEmail(result.getString(13));
				temp.add(customer);
			}
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	}
	
	
	//5
	public Customer modifyCustomer(String fName, String mName, String lName, String apt, String street, String city, 
			String st, String country, String zip, int phone, String email, int ssn) {
		establishConnection();
		String query = Queries.MODIFY_CUSTOMER;
		
		try {
			state = conn.prepareStatement(query);
			state.setString(1, fName); 
			state.setString(2, mName); 
			state.setString(3, lName); 
			state.setString(4, apt);
			state.setString(5,  street); 
			state.setString(6, city); 
			state.setString(7, st); 
			state.setString(8, country);
			state.setString(9, zip);
			state.setInt(10, phone); 
			state.setString(11, email); 
			state.setInt(12, ssn);
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	
	
	
	//6
	public Customer getCreditBillByMonthYear(String card, int month, int year) {
		establishConnection();
		String query = Queries.GET_CARD_BILL_BY_MONTH_YEAR;
		
		try {
			state = conn.prepareStatement(query);
			state.setString(1, card);
			state.setInt(2,  month);
			state.setInt(3, year);
			result = state.executeQuery();
			
			if (result.next()) {
				customer = new Customer();
				customer.setSum(result.getDouble(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	
	
	//7
	public ArrayList<Transaction> getTranByCustDate(int ssn, String date1, String date2){
		Transaction transaction = null;
		ArrayList<Transaction> temp = new ArrayList<>();
		establishConnection();
		String query = Queries.GET_TRAN_BY_CUST_DATE;
		
		try {
			state = conn.prepareStatement(query);
			state.setInt(1, ssn);
			state.setString(2, date1);
			state.setString(3, date2);
			result = state.executeQuery();
			
			while (result.next()) {
				transaction = new Transaction();
				transaction.setTranID(result.getInt(1));
				transaction.setDay(result.getInt(2));
				transaction.setMonth(result.getInt(3));
				transaction.setYear(result.getInt(4));
				transaction.setCreditNo(result.getString(5));
				transaction.setBranchCode(result.getInt(6));
				transaction.setTranType(result.getString(7));
				transaction.setTranVal(result.getDouble(8));
				temp.add(transaction);
			}
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
	
	
	
	

	public  Customer getCustomerInfo(int ssn) {
		establishConnection();
		String query = Queries.GET_CUST_BY_SSN;
		try {
			state = conn.prepareStatement(query);
			state.setInt(1, ssn);
			result = state.executeQuery();
			
			if (result.next()){
				customer = new Customer();
				customer.setfName(result.getString(1));
				customer.setmName(result.getString(2));
				customer.setlName(result.getString(3));
				customer.setSsn(result.getInt(4));
				customer.setCreditNo(result.getString(5));
				customer.setAptNo(result.getString(6));
				customer.setStreet(result.getString(7));
				customer.setCity(result.getString(8));
				customer.setState(result.getString(9));
				customer.setCountry(result.getString(10));
				customer.setZip(result.getString(11));
				customer.setPhone(result.getInt(12));
				customer.setEmail(result.getString(13));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
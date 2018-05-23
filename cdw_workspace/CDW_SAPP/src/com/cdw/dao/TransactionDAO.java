package com.cdw.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cdw.model.Transaction;
import com.cdw.resources.Queries;

public class TransactionDAO extends AbstractDAO{
	Transaction  transaction = null;
	
	
	//1
	public ArrayList<Transaction> getTranByZip (String zip, int month, int year) {
		ArrayList<Transaction> temp = new ArrayList<>();
		establishConnection();
		String query = Queries.Get_Tran_By_ZIP;

		try {
			state = conn.prepareStatement(query);
			state.setString(1, zip);
			state.setInt(2, month);
			state.setInt(3, year);
			result = state.executeQuery();
			
			while (result.next()) {
				transaction = new Transaction();
				transaction.setTranID(result.getInt(1));
				transaction.setDay(result.getInt(2));
				transaction.setMonth(result.getInt(3));
				transaction.setYear(result.getInt(4));
				transaction.setCreditNo(result.getString(5));
				transaction.setSsn(result.getInt(6));
				transaction.setBranchCode(result.getInt(7));
				transaction.setTranType(result.getString(8));
				transaction.setTranVal(result.getDouble(9));
				temp.add(transaction);
			}
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//2
	public Transaction getTranSumByTranType (String type) {
		establishConnection();
		String query = Queries.GET_TRAN_SUM_BY_TRAN_TYPE;
		
		try {
			state = conn.prepareStatement(query);
			state.setString(1, type);
			result = state.executeQuery();
			
			if (result.next()) {
				transaction = new Transaction();
				transaction.setCount(result.getInt(1));
				transaction.setTranVal(result.getDouble(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transaction;
	}
	
	
	//3
	public ArrayList<Transaction> getTranSumByState (String st) {
		ArrayList<Transaction> temp = new ArrayList<>();
		establishConnection();
		String query = Queries.GET_TRAN_SUM_BY_STATE;
		
		try {
			state = conn.prepareStatement(query);
			state.setString(1,  st);
			result = state.executeQuery();
			
			while (result.next()) {
				transaction = new Transaction();
				transaction.setTranType(result.getString(1));
				transaction.setCount(result.getInt(2));
				transaction.setTranVal(result.getDouble(3));
				temp.add(transaction);
			}
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
}

package com.cdw.resources;

public class Queries {
	
	
	//1
	public final static String Get_Tran_By_ZIP = 
			"select cc.transaction_id, cc.day, cc.month, cc.year, cc.credit_card_no, cc.cust_ssn, cc.branch_code, cc.transaction_type, cc.transaction_value "
			+ "from cdw_sapp_creditcard cc join cdw_sapp_customer c on cc.cust_ssn = c.ssn "
			+ "where c.cust_zip = ? and cc.month = ? and cc.year = ? "
			+ "order by cc.day desc";
	
	//2
	public final static String GET_TRAN_SUM_BY_TRAN_TYPE =
			"select count(transaction_type), sum(transaction_value) from cdw_sapp_creditcard where transaction_type = ? group by transaction_type";
	
	//3
	public final static  String GET_TRAN_SUM_BY_STATE =
			"select b.branch_name, count(cc.transaction_id), sum(cc.transaction_value) "
			+ "from cdw_sapp_creditcard cc join cdw_sapp_branch b using(branch_code) "
			+ "group by b.branch_code, b.branch_state having b.branch_state = ?";

	
	
	
	//4
	public final static String GET_CUST_BY_SSN = 
			"select * from CDW_SAPP_CUSTOMER where ssn = ?";
	
	//5
	public final static String MODIFY_CUSTOMER =
			"update cdw_sapp_customer set first_name = ?, middle_name = ?, last_name = ?, apt_no = ?, street_name = ?, cust_city = ?, "
			+ "cust_state = ?, cust_country = ?, cust_zip = ?, cust_phone = ?, cust_email = ? where ssn = ?";
	
	
	//6
	public final static String GET_CARD_BILL_BY_MONTH_YEAR =
			"select sum(transaction_value) from cdw_sapp_creditcard where credit_card_no = ? and month = ? and year = ? group by month, year";
	
	//7
	public final static String GET_TRAN_BY_CUST_DATE =
			"select transaction_id, day, month, year, credit_card_no, branch_code, transaction_type, transaction_value from cdw_sapp_creditcard "
			+ "where cust_ssn = ? having str_to_date(concat(month, '/', day, '/', year), '%m/%d/%Y')  "
			+ "between str_to_date(?, '%m/%d/%Y') and str_to_date(?, '%m/%d/%Y')"
			+ "order by year desc, month desc, day desc";
}
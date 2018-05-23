package com.cdw.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public abstract class AbstractDAO {

	protected Connection conn = null;
	protected PreparedStatement state = null;
	protected ResultSet result = null;
	
	protected void establishConnection(){
		try {
			Properties prop = new Properties();
			FileInputStream fs = new FileInputStream(
				this.getClass().getClassLoader()
				.getResource("com/cdw/resources/db.properties").getFile()
				);
			prop.load(fs);
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password") );
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	

	protected void closeConnetion(){
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

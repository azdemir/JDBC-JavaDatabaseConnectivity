package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Task {

	/*
	 * Create connection to db and retrieve all job titles and store them inside
	 * arraylist
	 * 
	 */

	private static String user = "syntax_hrm";
	private static String pass = "syntaxhrm123";
	private static String URL = "jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";

	@Test
	public void getData() throws SQLException {
		
		Connection con = DriverManager.getConnection(URL, user, pass);
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("select * from ohrm_job_title;");
		
		ArrayList<String> arrdata = new ArrayList<>();
		
		while (result.next()) {
			arrdata.add(result.getString("job_title"));
		}
		
		for(String db:arrdata) {
			System.out.println(db);
		}
		
		result.close();
		st.close();
		con.close();
		
////////////////////////////////
		
		List<String> job_titles = new ArrayList<>();
		try {
			
			Connection con1 = DriverManager.getConnection(URL, user, pass);
			Statement st1 = con.createStatement();
			ResultSet result1 = st.executeQuery("select * from ohrm_job_title;");
			
			while (result1.next()) {
				job_titles.add(result1.getString("job_title"));
			}

			result1.close();
			st1.close();
			con1.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(job_titles);
		
////////////////////////////////
		
		
		
	}

}

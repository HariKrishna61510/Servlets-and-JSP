package com.login.dao;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class LoginDao 
{
	String url = "jdbc:mysql://localhost:3307/javaee";
	String username = "root";
	String password = "9912012447";
	
	String sql = "select * from login where uname=? and pass = ?" ;
		public boolean check(String uname, String pass)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url , username, password);
				PreparedStatement st =con.prepareStatement(sql);
				st.setString(1, uname);
				st.setString(2, pass);
				ResultSet rs = st.executeQuery();
				if(rs.next())
				{
						return true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("executing");

			return false;
			
		}
	
	
}

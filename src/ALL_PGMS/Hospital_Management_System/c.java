package ALL_PGMS.Hospital_Management_System;
import java.sql.*;
import java.util.*;

public class c {
	private static Scanner input = new Scanner(System.in);
	public void createDb(String name) throws Exception
	{
		try {
			String url="jdbc:mysql://localhost:3306";
			String password = "";
			String username = "root";
			Connection conn = DriverManager.getConnection(url,username,password);
			Statement st = conn.createStatement();
			System.out.print("Connected");
			String Query = "create database "+name;
			boolean t = st.execute(Query);
			System.out.print(t);
			
			
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public void createTable()
	{
		
	}
	public static void main(String[] args) throws Exception
	{
		c obj = new c();
		String name = input.next();
		obj.createDb(name);
	}

}

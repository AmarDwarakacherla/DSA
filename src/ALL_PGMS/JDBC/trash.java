package ALL_PGMS.JDBC;
import java.sql.*;
import java.util.*;


public class trash {
	static Scanner input = new Scanner(System.in);
	public static class DB
	{
		public static void createDB(String name)
		{
			try {
				String url = "jdbc:mysql://localhost:3306/moca";
				String userName = "root";
				String password = "";
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url,userName,password);
				Statement st = conn.createStatement();
				System.out.print("Connected");
				String query = "create database "+name;
				boolean bl = st.execute(query);
				System.out.print(bl);
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public static void createTable(String name)
		{
			try {
				String url = "jdbc:mysql://localhost:3306/Amari";
				String userName = "root";
				String password = "";
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url,userName,password);
				Statement st = conn.createStatement();
				System.out.print("Connected");
				String query = "create table "+name+" (rollno int(3))";
				boolean bl = st.execute(query);
				System.out.print(bl);
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public void createData()
		{
			try {
				int x=input.nextInt();
				String url = "jdbc:mysql://localhost:3306/";
				String db = "Amari";
				String userName = "root";
				String password = "";
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url+db,userName,password);
				Statement st = conn.createStatement();
//				String query = "Insert into Amar (rollno) values(10)";
				
				String query = "Insert into Amar(rollno) values(?)";
				
				PreparedStatement pre = conn.prepareStatement(query);
				pre.setInt(1, x);
				
				
				pre.executeUpdate();
				System.out.print("Connected");
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args)
	{
		DB db = new DB();
//		db.createDB("Harsh");
		db.createData();
		
		
		
	}
	

}

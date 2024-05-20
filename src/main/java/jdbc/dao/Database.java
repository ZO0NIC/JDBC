package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

import zonic.Employee;

public class Database {
	static Connection con=null;
	static {
		try {
			
			Properties ps = new Properties();
			ps.put("user", "root");
			ps.put("password", "root");
			Driver d = new Driver();
			con = d.connect("jdbc:mysql://localhost:3306/demodb", ps);
//			 con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb", ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	public void AddColumn(String col,int num,String ph)
	{
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(String.format("alter table employee add "+col+" "+ph+" ("+255+")"));
			//stmt.executeUpdate(String.format("alter table employee drop column mob"));
			System.out.println("update column successfull");

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	public void insert(Employee Anupam) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(String.format("insert into employee(id ,name, age,gender) values(%d,\"%s\",\"%s\",\"%s\") ",Anupam.getId(), Anupam.getName(), Anupam.getAge(), Anupam.getGender()));
			System.out.println("transaction successfull");

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	public void update(Employee e)
	{
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(String.format("update employee set name=\"%s\",age=\"%s\",gender=\"%s\" where id = %d", e.getName(), e.getAge(), e.getGender(),e.getId()));
			System.out.println("update successfull");

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	public void updateE(String col,String name,int id,Employee e)
	{
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(String.format("update employee set "+col+" = '"+name+"' where id = "+id));
			System.out.println("update successfull");

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	public void showEmployees() {
		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("select * from demodb.employee");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void findByName(String name) {
		// "22' OR 1 = 1"
		try (Statement stmt = con.createStatement()) {
			String sql = "select * from employee where name ='" + name;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
						System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("hiii");
			e.printStackTrace();
		}
		
		System.out.println("SQL IN");
	}
	
	public List convo() {
		List ls = new ArrayList();
		// "22' OR 1 = 1"
		try (Statement stmt = con.createStatement()) {
			String sql = "select * from employee";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
						ls.add(rs.getInt(1));
						ls.add(rs.getString(2));
						ls.add(rs.getString(3));
						ls.add(rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("hiii");
			e.printStackTrace();
		}
		System.out.println("SQL IN IN");
		return ls;
	}
	
}
	

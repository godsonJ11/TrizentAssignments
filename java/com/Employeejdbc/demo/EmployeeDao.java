package com.Employeejdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDao {
	EmployeeDetails employee = new EmployeeDetails();
	public void displayAll() {
		Connection con = null;
	    Statement stmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee?user = root & password = root");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from EmployeeDetails;");
			while(rs.next()) {
				System.out.println("Employee Name : " + rs.getString(1)+"\n"
						+ "Employee email id : "+ rs.getString("emailid")+"\n"
						+ "Employee Permanent Address :" + rs.getString("epAddress")+"\n"
						+ "Employee Corresponding Address :" + rs.getString("ecAddress")+"\n"
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt !=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void searchEmployee(String email) {
		Connection con = null;
	    Statement stmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee?user = root & password = root");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from EmployeeDetails where emailid = '"+ email +"';");
			if(rs.next()) {
				System.out.println("Employee Name : " + rs.getString(1)+"\n"
						+ "Employee email id : "+ rs.getString("emailid")+"\n"
						+ "Employee Permanent Address :" + rs.getString("epAddress")+"\n"
						+ "Employee Corresponding Address :" + rs.getString("ecAddress")+"\n"
						);
			}else {
				System.out.println("Not Found...Enter the Valid Email.....");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt !=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public boolean deleteEmployee(String email) {
		boolean res = false;
		Connection con = null;
	    Statement stmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee?user = root & password = root");
			stmt = con.createStatement();
			int nord = stmt.executeUpdate("delete from EmployeeDetails where emailid = '"+email+"'");
			if(nord == 1) {
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt !=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}return res;
	}
	public boolean addEmployee(EmployeeDetails dao) {
		boolean res = false;
		Connection con = null;
	    Statement stmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee?user = root & password = root");
			stmt = con.createStatement();
			int nori = stmt.executeUpdate("insert into EmployeeDetails values('"+ dao.geteName() +"','"+ dao.geteEmail()+"','"+ dao.getpAddress()+"','"+ dao.getcAddress()+"');");
			if(nori == 1) {
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt !=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return res;
	}
}

package com.cogent.CRUD.CRUDSpring.REST;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.CRUD.CRUDSpring.Common.DatabaseConnection;
import com.cogent.CRUD.CRUDSpring.Common.Employee;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@RestController
public class CRUDController{
	
	
	private  Employee Employee1 = new Employee();
	private DatabaseConnection dataConnect;
	private Connection con ;
	private String query;
	private PreparedStatement stmt = null; 

	@Autowired
	public CRUDController(DatabaseConnection dataConnect) {
		this.dataConnect = dataConnect;
	}
	
	@PostConstruct
	public void postContruct() throws SQLException
	{
		System.out.println("Bean Created");
		DataSource dataSource = dataConnect.getDataSource();
		con = dataSource.getConnection();
		System.out.println("Connected to database");
		
	}
	@PreDestroy
	public void preDestroy() throws SQLException {
		con.close();
	}
		
	@PostMapping("/addEmployee")
	public String addEmp(@ModelAttribute Employee e) throws SQLException
	{
		query = "insert into employee values(?,?,?,?)";
		stmt = con.prepareStatement(query);
		stmt.setInt(1, e.getId());
		stmt.setString(2, e.getName());
		stmt.setInt(3, e.getAge());
		stmt.setInt(4, e.getSalary());
		stmt.executeUpdate();
		return "Employee Id Number:" + e.getId() + " added";
	}
	@GetMapping("/getEmployee/{id}")
	public Employee getE(@PathVariable int id) throws SQLException {
		query = "select * from employee where emp_id = " + id;
		stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			Employee1.setId(rs.getInt(1));
			Employee1.setName(rs.getString(2));
			Employee1.setAge(rs.getInt(3));
			Employee1.setSalary(rs.getInt(4));
		}
		return Employee1 ;
	}
	@GetMapping("/getEmployeeMetaData")
	public StringBuilder getEmployeMD() throws SQLException
	{
		query = "select * from employee";
		stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rMeta = rs.getMetaData();
		StringBuilder result = new StringBuilder();
		for(int i = 1; i <= rMeta.getColumnCount(); i++)
		{
			result.append("Column Name: \t" + rMeta.getColumnName(i) + " " + rMeta.getColumnType(i)
					+ " Catalog Name: \t" + rMeta.getCatalogName(i)+ " " + rMeta.getColumnLabel(i));
		}
		return result;
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) throws SQLException
	{
		query = "delete from employee where emp_id = " + id;
		stmt = con.prepareStatement(query);
		stmt.executeUpdate();
		return "Employee " + id + " deleted";
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute Employee e) throws SQLException {
		query = "update employee set name = ?,"
				+ "age = ?,"
				+ "salary = ? "
				+ "where emp_id = ?;" ;
		stmt = con.prepareStatement(query);
		stmt.setString(1, e.getName());
		stmt.setInt(2, e.getAge());
		stmt.setInt(3, e.getSalary());
		stmt.setInt(4, e.getId());
		stmt.executeUpdate();
		System.out.println(stmt.toString());
		return "Employee id :" + e.getId() + " updated";
	}
	
	
	

}

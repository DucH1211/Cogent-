package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAORepository implements UserDAO {
//@Autowired
//DataSource ds;
//DatabaseConfiguration dbconfig;
@Autowired
JdbcTemplate jt;
	@Override
	public boolean saveUser(User user) throws Exception{
		// TODO Auto-generated method stub
		/*String driver=dbconfig.getDriver();
		String password=dbconfig.getPassword();
		String username=dbconfig.getUsername();
		String url=dbconfig.getUrl();*/
		//Class.forName(driver);
		
		//Connection con=ds.getConnection();
		String query="insert into userdetail values(?,?,?,?)";
		/*PreparedStatement pmt=con.prepareStatement(query);
		pmt.setInt(1, user.getId());
		pmt.setString(2, user.getName());
		pmt.setString(3, user.getEmail());
		pmt.setInt(4, user.getAge());*/
		int i=jt.update(query, new Object[] {user.getId(),user.getName(),user.getEmail(),user.getAge()});
		
		
		if(i>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateUser(User user, int id) {
		// TODO Auto-generated method stu                                                                                                                                                                                                                          b
		return false;
	}

	@Override
	public boolean delteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findAll(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}

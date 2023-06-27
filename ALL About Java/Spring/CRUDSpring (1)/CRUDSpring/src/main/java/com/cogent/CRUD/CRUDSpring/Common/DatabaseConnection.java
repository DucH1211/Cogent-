package com.cogent.CRUD.CRUDSpring.Common;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jdbc.mysql") //this is replacement for @Value
public class DatabaseConnection {
//	@Value("${jdbc.mysql.url}") //$ is runtime expression
	private String url;
//	@Value("${jdbc.mysql.username}")
	private String username;
//	@Value("${jdbc.mysql.driver}")
	private String driver;
//	@Value("${jdbc.mysql.password}")
	private String password;
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DataSource getDataSource() {
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName(driver);
		dm.setUrl(url);
		dm.setUsername(username);
		dm.setPassword(password);
		return dm;
	}
}

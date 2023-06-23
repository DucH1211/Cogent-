package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public interface UserDAO {
	public boolean saveUser(User user)throws Exception;
	public boolean updateUser(User user,int id)throws Exception;
	public boolean delteUser(int id)throws Exception;
	public boolean findAll(User user)throws Exception;

}

package com.cogent.CRUD.CRUDSpring.Common;

import org.springframework.stereotype.Service;

@Service //business function
public interface EmployeeDAO {
	public boolean saveEmployee(Employee e);
	public boolean updateEmployee(Employee e, int id);
	public boolean deleteUser(int id);
	public boolean findAll(Employee e);
	
}

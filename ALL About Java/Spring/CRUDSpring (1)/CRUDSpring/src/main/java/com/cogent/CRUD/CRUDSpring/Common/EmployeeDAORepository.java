package com.cogent.CRUD.CRUDSpring.Common;

import org.springframework.stereotype.Repository;

@Repository //DAO Service class implementation the Service Layer
public class EmployeeDAORepository implements EmployeeDAO{
	@Override
	public boolean saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(Employee e, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findAll(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

}

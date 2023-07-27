package com.microservice.eurekaclient.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.eurekaclient.employeeservice.entity.Employee;


/**
 * {@link Repository}
 * Interface to uses specification from JpaRepository
 * @author tmyho
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

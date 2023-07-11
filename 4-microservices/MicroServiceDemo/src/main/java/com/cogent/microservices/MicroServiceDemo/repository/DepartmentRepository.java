package com.cogent.microservices.MicroServiceDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cogent.microservices.MicroServiceDemo.entity.Department;

/**
 * Interface to uses specification from JpaRepository
 * @author tmyho
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
}

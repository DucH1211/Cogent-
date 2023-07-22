package com.microservice.CustomerService.service;

import com.microservice.CustomerService.entity.Customer;
import com.microservice.CustomerService.entity.for_dto.CustomerAccountDTO;
import com.microservice.CustomerService.entity.stub.Account;
import com.microservice.CustomerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {
    /**
     * Save given customer to database
     * @param theCustomer
     * @return
     */
    Customer save(Customer theCustomer);

    /**
     * update the customer in database
     * @param theCustomer
     * @return
     */
    void update(Customer theCustomer,int id);

    /**
     * return List of all customer available in database
     * @return
     */
    List<Customer> getAll();

    /**
     * return a customer with given customer_id
     * @return
     */
    Customer getById(int id);

    /**
     * save an account associated with a customer
     * @return
     */
    CustomerAccountDTO getAccount(int employee_id);
    String createAccount(int customer_id,Account theAccount);
    String saveAccount(int customer_id,Account theAccount);
}

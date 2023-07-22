package com.microservice.CustomerService.controller;

import com.microservice.CustomerService.entity.Customer;
import com.microservice.CustomerService.entity.for_dto.CustomerAccountDTO;
import com.microservice.CustomerService.entity.stub.Account;
import com.microservice.CustomerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAll();
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Customer customer,@PathVariable int id)
    {
        customerService.update(customer,id);
    }
    @PostMapping
    public Customer save(@RequestBody Customer theCustomer)
    {
        return customerService.save(theCustomer);
    }
    @GetMapping("/{id}")
    public Customer getbyid(@PathVariable int id)
    {
        return customerService.getById(id);
    }
    @GetMapping("/{id}/account")
    public CustomerAccountDTO getDTO(@PathVariable int id)
    {
            return customerService.getAccount(id);
    }
    @PostMapping("/{id}/createaccount")
    public String createAccount(@PathVariable int id,@RequestBody Account account)
    {
        return customerService.createAccount(id,account);
    }
    @PutMapping("/{id}/savecustomeraccount")
    public String saveCustomerAccount(@PathVariable int id,@RequestBody Account account){
        return customerService.saveAccount(id,account);
    }
}

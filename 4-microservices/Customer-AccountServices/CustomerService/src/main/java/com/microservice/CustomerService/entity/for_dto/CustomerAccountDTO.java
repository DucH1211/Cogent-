package com.microservice.CustomerService.entity.for_dto;

import com.microservice.CustomerService.entity.Customer;
import com.microservice.CustomerService.entity.stub.Account;

public class CustomerAccountDTO {
    private Customer theCustomer;
    private Account theAccount;

    public Customer getTheCustomer() {
        return theCustomer;
    }

    public void setTheCustomer(Customer theCustomer) {
        this.theCustomer = theCustomer;
    }

    public Account getTheAccount() {
        return theAccount;
    }

    public void setTheAccount(Account theAccount) {
        this.theAccount = theAccount;
    }




}

package com.microservice.CustomerService.service;

import com.microservice.CustomerService.entity.Customer;
import com.microservice.CustomerService.entity.for_dto.CustomerAccountDTO;
import com.microservice.CustomerService.entity.stub.Account;
import com.microservice.CustomerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CustomerRepository theRepository;
    @Override
    public Customer save(Customer theCustomer) {
        return theRepository.save(theCustomer);
    }
    @Override
    public void update(Customer theCustomer,int id) throws RuntimeException
    {

        if(theRepository.existsById(id))
        {
            theRepository.deleteById(id);
            save(theCustomer);
        }else {
            save(theCustomer);
        }
    }
    @Override
    public List<Customer> getAll() {
        return theRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        try {
            return theRepository.findById(id).get();
        }catch(Exception e)
        {
            e.toString();
            return null;
        }

    }

    @Override
    public CustomerAccountDTO getAccount(int customer_id) {
        CustomerAccountDTO theDTO = new CustomerAccountDTO();
        //retrieve Customer
        Customer theCustomer = theRepository.findById(customer_id).get();
        try
        {
            String url = "http://localhost:9161/api/account/" + theCustomer.getAccount_id();
            //retrieve Account
            Account account = restTemplate.getForObject(url,Account.class);
            //map account id to this Customer
            System.out.println(account.getEmail());
            System.out.println("this ran");
            account.setCustomer_id(customer_id);
            theDTO.setTheCustomer(theCustomer);
            theDTO.setTheAccount(account);
        }catch(Exception e)
        {
            System.out.println(e.toString());
            theDTO.setTheCustomer(theCustomer);
            theDTO.setTheAccount(null);
        }
        return theDTO;
    }

    /**
     * Still buggy
     * @param customer_id
     * @param account
     * @return
     */
    @Override
    public String createAccount(int customer_id, Account account) {
        Customer theCustomer = theRepository.findById(customer_id).get();
        try
        {
            account.setCustomer_id(customer_id);
            String url = "http://localhost:9161/api/account/";
            URI uri = restTemplate.postForLocation(url,account,Account.class); //save account to database, this method also return an URI object
            System.out.println("this ran");
            theCustomer.setAccount_id(account.getAccount_id());
            update(theCustomer,customer_id);
            return "Create Account Success" + uri.toString();
        }catch(Exception e)
        {
            e.printStackTrace();
            return "Create Account Fail";
        }
    }

    @Override
    public String saveAccount(int customer_id, Account account) {
        CustomerAccountDTO theDTO = new CustomerAccountDTO();
        Customer theCustomer = theRepository.findById(customer_id).get();
        try
        {
            String url = "http://localhost:9161/api/account/" + account.getAccount_id();
            //save account to database, this method also return an Account object
            restTemplate.put(url,account);
            account.setCustomer_id(customer_id);
            return "Successfully Saved";
        }catch(Exception e)
        {
            System.out.println(e.toString());
            return "Unsuccessful save";
        }
    }


}

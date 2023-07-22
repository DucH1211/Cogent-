package com.microservice.AccountService.service;

import com.microservice.AccountService.entity.Account;
import com.microservice.AccountService.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    /**
     * Use Jpa_Repository
     */
    @Autowired
    AccountRepository theRepository;

    /**
     * Use jpa repository to save the account
     * @param theAccount
     * @return
     */
    @Override
    public Account save(Account theAccount) {
        return theRepository.save(theAccount);
    }

    @Override
    public void update(Account account, int id) {
        if(theRepository.existsById(id))
        {
            theRepository.deleteById(id);
            theRepository.save(account);
        }else {
            theRepository.save(account);
        }
    }

    /**
     * find all account in the database and return as list object
     * only use for development
     * @return
     */
    @Override
    public List<Account> getAll() {
        return theRepository.findAll();
    }

    /**
     * return account with given id
     * @param account_id
     * @return
     */
    @Override
    public Account getAccountById(int account_id) {
        try {
            return theRepository.findById(account_id).get();
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

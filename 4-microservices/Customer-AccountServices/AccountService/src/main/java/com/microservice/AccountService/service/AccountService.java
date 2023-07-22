package com.microservice.AccountService.service;

import com.microservice.AccountService.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    /**
     * Use to save account
     * @param theAccount
     * @return
     */
    Account save(Account theAccount);
    /**
     * update the account with given id
     */
    void update(Account account, int id);

    /**
     * Use to return a List of Account
     * @return
     */
    List<Account> getAll();

    /**
     * return acccount with given account_id
     * @return
     */
    Account getAccountById(int account_id);

}

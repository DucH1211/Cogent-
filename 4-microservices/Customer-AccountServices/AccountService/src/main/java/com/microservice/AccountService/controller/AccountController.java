package com.microservice.AccountService.controller;

import com.microservice.AccountService.entity.Account;
import com.microservice.AccountService.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This will be restricted from use, not a Customer cannot access.
 * this feature currently not implemented.
 * 7-13-2023
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @GetMapping
    public List<Account> getAll()
    {
        return accountService.getAll();
    }
    @PostMapping
    public String save(@RequestBody Account theAccount)
    {
        Account account = accountService.save(theAccount);
        return "Account Successfully created" + account;
    }
    @GetMapping("/{id}")
    public Account getById(@PathVariable int id)
    {
        return accountService.getAccountById(id);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Account account,@PathVariable int id)
    {
        accountService.update(account,id);
    }
}

package com.levelup.service;

import com.levelup.model.Account;

import java.util.List;

/**
 * Created by denis_zavadsky on 2/21/15.
 */
public interface AccountService {

    Account getAccountById(Long id);
    Account getAccountByNumber(String accountNumber);
    List<Account> getAllAccounts();

    void createAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Account account);

    List<Account> searchByBankName(String bankName);
    List<Account> searchByCustomerName(String firstName, String lastName);
}

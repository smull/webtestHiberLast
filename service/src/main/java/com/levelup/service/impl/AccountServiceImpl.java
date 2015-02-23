package com.levelup.service.impl;

import com.levelup.dao.AccountRepository;
import com.levelup.dao.BankRepository;
import com.levelup.dao.CustomerRepository;
import com.levelup.dao.impl.AccountRepositoryImpl;
import com.levelup.dao.impl.BankRepositoryImpl;
import com.levelup.dao.impl.CustomerRepositoryImpl;
import com.levelup.model.Account;
import com.levelup.service.AccountService;

import java.util.List;

/**
 * Created by denis_zavadsky on 2/21/15.
 */
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository = new AccountRepositoryImpl();

    private BankRepository bankRepository = new BankRepositoryImpl();

    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.getAccountById(id);
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.getAccountByNumber(accountNumber);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @Override
    public void createAccount(Account account) {
        bankRepository.createBank(account.getBank());
        customerRepository.createCustomer(account.getCustomer());
        accountRepository.createAccount(account);
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Account account) {

    }

    @Override
    public List<Account> searchByBankName(String bankName) {
        return accountRepository.getAccountsByBankName(bankName);
    }

    @Override
    public List<Account> searchByCustomerName(String firstName, String lastName) {
        return accountRepository.getAccountsByCustomerName(firstName,lastName);
    }
}

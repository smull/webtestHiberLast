package com.levelup.dao;

import com.levelup.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

/**
 * Created by denis_zavadsky on 2/12/15.
 */
public interface AccountRepository {

    Account getAccountById(Long id);
    Account getAccountByNumber(String accountNumber);
    List<Account> getAllAccounts();

    void createAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Account account);

    List<Account> getAccountsByBankId(Long id);
    List<Account> getAccountsByBankName(String name);
    List<Account> getAccountsByCustomerName(String firstName, String lastName);

}

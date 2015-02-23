package com.levelup.dao.impl;

import com.levelup.dao.AccountRepository;
import com.levelup.dao.HibernateSessionProvider;
import com.levelup.model.Account;
import com.levelup.model.Bank;
import com.levelup.model.Customer;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by denis_zavadsky on 2/19/15.
 */
public class AccountRepositoryImpl implements AccountRepository {

    public AccountRepositoryImpl() {

    }

    @Override
    public Account getAccountById(Long id) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Account account = (Account) session.get(Account.class,id);
        session.getTransaction().commit();
        session.close();
        return account;
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Account a where a.accountNumber = :accountNumber");
        query.setParameter("accountNumber",accountNumber);
        List<Account> accounts = (List<Account>) query.list();
        session.getTransaction().commit();
        session.close();

        return accounts.size()>0?accounts.get(0):null;
    }

    @Override
    public List<Account> getAllAccounts() {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Account a ");
        List<Account> accounts = (List<Account>) query.list();
        session.getTransaction().commit();
        session.close();

        return accounts;
    }

    @Override
    public void createAccount(Account account) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Bank bank = (Bank) session.get(Bank.class, account.getBank().getId());
        Customer customer = (Customer) session.get(Customer.class, account.getCustomer().getId());
        account.setBank(bank);
        account.setCustomer(customer);
        session.persist(account);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateAccount(Account account) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Account sourceAccount = (Account) session.get(Account.class, account.getId());
        sourceAccount.setAccountNumber(account.getAccountNumber());
        sourceAccount.setBalance(account.getBalance());
        sourceAccount.setCustomer(account.getCustomer());
        session.merge(sourceAccount);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAccount(Account account) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        account = (Account) session.get(Account.class, account.getId());
        session.delete(account);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Account> getAccountsByBankId(Long id) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Account as a where a.bank.id = :id");
        query.setParameter("id",id);
        List<Account> result = query.list();
        return result;
    }

    @Override
    public List<Account> getAccountsByBankName(String name) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Account as a where a.bank.name = :name");
        query.setParameter("name",name);
        List<Account> result = query.list();
        return result;
    }

    @Override
    public List<Account> getAccountsByCustomerName(String firstName, String lastName) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Account as a where a.customer.firstName like :firstName " +
                "and a.customer.lastName like :lastName");
        query.setParameter("firstName",firstName+"%");
        query.setParameter("lastName",lastName+"%");
        List<Account> result = query.list();
        return result;
    }
}

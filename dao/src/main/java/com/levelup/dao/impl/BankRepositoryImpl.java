package com.levelup.dao.impl;

import com.levelup.dao.BankRepository;
import com.levelup.dao.HibernateSessionProvider;
import com.levelup.model.Bank;
import org.hibernate.Session;

/**
 * Created by denis_zavadsky on 2/21/15.
 */
public class BankRepositoryImpl implements BankRepository {

    @Override
    public void createBank(Bank bank) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        session.persist(bank);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Bank getBankById(Long id) {
        Session session = HibernateSessionProvider.getSession();
        session.beginTransaction();
        Bank bank = (Bank) session.get(Bank.class,id);
        session.getTransaction().commit();
        session.close();
        return bank;
    }
}

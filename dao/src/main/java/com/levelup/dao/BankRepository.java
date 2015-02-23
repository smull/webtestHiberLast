package com.levelup.dao;

import com.levelup.model.Bank;

/**
 * Created by denis_zavadsky on 2/21/15.
 */
public interface BankRepository {

    void createBank(Bank bank);

    Bank getBankById(Long id);
}

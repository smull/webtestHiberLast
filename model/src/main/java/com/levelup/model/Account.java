package com.levelup.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by denis_zavadsky on 2/12/15.
 */
@Entity
@Table(name = "ACCOUNT")
public class Account extends BusinessObject {

    private Long id;

    private String accountNumber;

    private Float balance;

    private Customer customer;

    private Bank bank;

    private List<Transaction> transactions;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column
    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Transient
    public void getBalanceWithoutFees(){

    }

    @OneToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToOne(targetEntity = Bank.class)
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Transaction.class, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ACCOUNT_TRANSACTIONS", joinColumns = {@JoinColumn(name = "ACCOUNT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "TRANSACTION_ID")})
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}

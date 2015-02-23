package com.levelup.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by denis_zavadsky on 2/19/15.
 */
@Entity
@Table(name = "TRANSACTION")
public class Transaction extends BusinessObject{

    private Long id;

    private Float amount;

    private Date date;

    private Account sourceAccount;

    private Account destinationAccount;

    public Transaction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(targetEntity = Account.class)
    @JoinTable(name = "ACCOUNT_TRANSACTIONS", inverseJoinColumns = {@JoinColumn(name = "ACCOUNT_ID")},
            joinColumns = {@JoinColumn(name = "TRANSACTION_ID")})
    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    @ManyToOne(targetEntity = Account.class)
    @JoinTable(name = "ACCOUNT_TRANSACTIONS", inverseJoinColumns = {@JoinColumn(name = "ACCOUNT_ID")},
            joinColumns = {@JoinColumn(name = "TRANSACTION_ID")})
    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}

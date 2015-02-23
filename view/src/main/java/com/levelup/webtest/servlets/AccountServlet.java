package com.levelup.webtest.servlets;

import com.levelup.model.Account;
import com.levelup.model.Bank;
import com.levelup.model.Customer;
import com.levelup.service.AccountService;
import com.levelup.service.impl.AccountServiceImpl;
import com.levelup.webtest.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by denis_zavadsky on 2/21/15.
 */
public class AccountServlet extends HttpServlet {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = getAccount(request);
        AccountService accountService = new AccountServiceImpl();
        accountService.createAccount(account);

        request.getSession().setAttribute("objectId", account.getId());
        response.sendRedirect("success.jsp");
    }

    private Account getAccount(HttpServletRequest request){
        Account account = new Account();
        Bank bank = new Bank();
        Customer customer = new Customer();
        account.setAccountNumber(request.getParameter(Constants.ACCOUNT_NUMBER_PARAMETER));
        account.setBalance(Float.parseFloat(request.getParameter(Constants.ACCOUNT_BALANCE_PARAMETER)));

        bank.setName(request.getParameter(Constants.BANK_NAME_PARAMETER));

        customer.setFirstName(request.getParameter(Constants.FIRST_NAME_PARAMETER));
        customer.setLastName(request.getParameter(Constants.LAST_NAME_PARAMETER));

        String date = request.getParameter(Constants.BIRTH_DATE_PARAMETER);
        try {
            Date birthDate = dateFormat.parse(date);
            customer.setBirthDate(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        account.setBank(bank);
        account.setCustomer(customer);
        return account;
    }
}

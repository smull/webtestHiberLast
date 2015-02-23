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
import java.util.List;

/**
 * Created by SMULL on 22.02.2015.
 */
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        String bankName = request.getParameter(Constants.BANK_NAME_PARAMETER);
        List<Account> accounts = accountService.searchByBankName(bankName);

        request.getSession().setAttribute("accounts",accounts);
        response.sendRedirect("resultBySearchByBankName.jsp");



    }



}

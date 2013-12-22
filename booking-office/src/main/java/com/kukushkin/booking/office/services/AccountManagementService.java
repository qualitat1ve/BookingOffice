package com.kukushkin.booking.office.services;

import java.sql.SQLException;

import com.kukushkin.booking.office.dao.AccountDao;
import com.kukushkin.booking.office.dao.AccountDaoImpl;
import com.kukushkin.booking.office.entity.Account;

public class AccountManagementService {
    private AccountDao accountDao;

    public AccountManagementService() {
        accountDao = new AccountDaoImpl();
    }

    public void createAccount(Account account) {
        try {
            accountDao.add(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editAccount(Account account) {
        try {
            accountDao.update(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void blockAccount(Account account) {
        try {
            account.setLogin(Account.INACTIVE_ACCOUNT_STATUS);
            accountDao.update(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


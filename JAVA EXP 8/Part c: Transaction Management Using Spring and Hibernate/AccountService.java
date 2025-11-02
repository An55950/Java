package com.example.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Transactional
    public void transferMoney(int fromId, int toId, double amount) {
        Account fromAcc = accountDAO.getAccount(fromId);
        Account toAcc = accountDAO.getAccount(toId);

        fromAcc.setBalance(fromAcc.getBalance() - amount);
        toAcc.setBalance(toAcc.getBalance() + amount);

        accountDAO.updateAccount(fromAcc);
        accountDAO.updateAccount(toAcc);
    }
}

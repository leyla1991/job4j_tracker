package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (user != null) {
            accounts.add(account);
            users.putIfAbsent(user, accounts);

            }
    }

    public User findByPassport(String passport) {
        User pass = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                pass = user;
            }
        }
        return pass;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account account = null;
        List<Account> accounts = users.get(user);
        if (user != null) {
            for (Account acc : accounts) {
                if (acc.getRequisite().equals(requisite)) {
                    account = acc;
                }
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account account = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (account != null && accountDest != null && account.getBalance() >= (amount)) {
            account.setBalance(account.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}

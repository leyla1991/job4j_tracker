package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает добавление данных о клиенте банка,
 * а также поиск информации об уже зарегистрированных клиентах банка
 * и осуществление перевод между счетами клиента.
 * @author Ivannikova
 * @version 1.0
 * */
public class BankService {

    /**
     * Поле содержит всех пользователей (клиентов банка) системы с привязанными к ним счетами
     * Хранение осуществляется в интерфейсе типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет клиента в систему
     * @param user данные о клиенте,
     * если клиента нет в базе, метод его добавляет
     * */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет клиенту
     * @param passport номер паспорта клиента, по которому ищут,
     * @param account данные о наличии или отсутствию аккаунта клиента,
     * если есть аккаунт метод добавляет новый счет
     * */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта по которому ищут,
     * @return возвращает данные о пользователе или null, если он не найден
     * */
    public User findByPassport(String passport) {
        User pass = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                pass = user;
                break;
            }
        }
        return pass;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport номер паспорта клиента,
     * @param requisite номер счета клиента
     * @return возвращает обновленный аккаунт со счетами клиента или null, если не найден.
    */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account account = null;
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account acc : accounts) {
                if (acc.getRequisite().equals(requisite)) {
                    account = acc;
                }
            }
        }
        return account;
    }
    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * @param srcPassport номер паспорта клиента, который делает перевод,
     * @param srcRequisite номер счета клиента, с которого делается перевод,
     * @param destPassport номер паспорта клиента, которому переводят деньги,
     * @param destRequisite номер счета клиента, на который делают перевод
     * @param amount сумма перевода
     * @return  true, если операция прошла успешно или false, если такого счета не существует,
     * или на счете недостаточно средств
     */

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

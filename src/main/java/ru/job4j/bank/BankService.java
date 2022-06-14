package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport номер паспорта клиента,
     * @param requisite номер счета клиента
     * @return возвращает обновленный аккаунт со счетами клиента или null, если не найден.
    */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        return findByPassport(passport)
                .flatMap(u -> users.get(u)
                        .stream()
                        .filter(account -> account.getRequisite()
                                .equals(requisite))
                        .findFirst());
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
        Optional<Account> account = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
        if (account.isPresent() && accountDest.isPresent() && account.get().getBalance() >= (amount)) {
            account.get().setBalance(account.get().getBalance() - amount);
            accountDest.get().setBalance(accountDest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}


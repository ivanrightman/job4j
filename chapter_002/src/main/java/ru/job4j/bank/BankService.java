package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        this.users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!this.users.get(user).contains(account)) { //получить список по user и проверить по contains
            this.users.get(user).add(account);
        } else {
            System.out.println("Такой счет: " + account.getRequisite() + " уже есть у пользователя");
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User el : users.keySet()) {
            if (el.getPassport().equals(passport)) {
                user = el;
                break;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = new Account(requisite, -1);
        User user = findByPassport(passport);
        if (user != null) {
            int accIndex = this.users.get(user).indexOf(account);
            if (accIndex != -1) {
                account = this.users.get(user).get(accIndex);
            } else {
                System.out.println("Нет такого счета: " +  requisite);
                account = null;
            }
        } else {
            System.out.println("Нет такого юзера: " +  passport);
            account = null;
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null) {
            if (srcAcc.getBalance() >= amount) {
                double newSrcBalance = srcAcc.getBalance() - amount;
                double newDestBalance = destAcc.getBalance() + amount;
                srcAcc.setBalance(newSrcBalance);
                destAcc.setBalance(newDestBalance);
                rsl = true;
            } else {
                System.out.println("На счете: " + srcRequisite + " недостаточно денег для списания");
            }
        } else if (srcAcc == null){
            System.out.println("Не найден счет для списания: " + srcRequisite);
        } else if (destAcc == null){
            System.out.println("Не найден счет для зачисления: " + destRequisite);
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
        BankService bs = new BankService();
        User user = new User("passport", "username");
        bs.addUser(user);
        System.out.println(bs.users.entrySet());
        Account acc = new Account("1234", 101);
        ArrayList<Account> accList = new ArrayList<>();
        accList.add(acc);
        bs.users.put(user, accList);
        System.out.println(bs.users.entrySet());
        System.out.println(bs.users.keySet());
        System.out.println(bs.users.values());
        ArrayList<Account> accl = new ArrayList(bs.users.values());
        System.out.println(accl.get(0));
        int index1 = accList.indexOf(new Account("1234", -1));
        System.out.println(index1);
        System.out.println(accl.contains(accl.get(index1)));
    }
}

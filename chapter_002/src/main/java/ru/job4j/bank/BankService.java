package ru.job4j.bank;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        this.users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        for (User key : this.users.keySet()) {
            if (key.equals(user)) {
                for (List<Account> value : this.users.values()) {
                    if (!value.contains(account)) {
                        value.add(account);
                    } else {
                        System.out.println("Такой счет: " + account.getRequisite() + " уже есть у пользователя");
                    }
                }
            }
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User el : users.keySet()) {
            if (el.getPassport().equals(passport)) {
                user = el;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = new Account(requisite, -1);
        User user = findByPassport(passport);
        for (User key : this.users.keySet()) {
            if (key.equals(user)) {
                for (List<Account> value : this.users.values()) {
                    int accIndex = value.indexOf(account);
                    if (accIndex != -1 && value.get(accIndex).getRequisite().contains(requisite)) {
                        for (Account el : value) {
                            if (el.getRequisite() == requisite) {
                                account = el;
                            }
                        }
                    } else {
                        System.out.println("Нет такого счета: " +  requisite);
                        account = null;
                    }
                }
                if (account != null) {
                    break;
                }
            } else {
                account = null;
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        for (User key : users.keySet()) {
            for (List<Account> value : users.values()) {
                if (value.contains(srcAcc) && value.contains(destAcc) && srcAcc.getBalance() >= amount) {
                    int srcAccIndex = value.indexOf(srcAcc);
                    int destAccIndex = value.indexOf(destAcc);
                    double newSrcBalance = srcAcc.getBalance() - amount;
                    double newDestBalance = destAcc.getBalance() + amount;
                    srcAcc = (new Account(srcRequisite, newSrcBalance));
                    destAcc = (new Account (destRequisite, newDestBalance));
                    value.set(srcAccIndex, srcAcc);
                    value.set(destAccIndex, destAcc);
                    rsl = true;
                } else if (!value.contains(srcAcc)){
                    System.out.println("Не найден счет для списания: " + srcRequisite);
                } else if (!value.contains(destAcc)){
                    System.out.println("Не найден счет для зачисления: " + destRequisite);
                } else {
                    System.out.println("На счете: " + srcRequisite + " недостаточно денег для списания");
                }
            }
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

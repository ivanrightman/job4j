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
        Account account = null;
        User user = findByPassport(passport);
        for (User key : this.users.keySet()) {
            if (key.equals(user)) {
                for (List<Account> value : this.users.values()) {
                    if (value.get(0).getRequisite().contains(requisite)) {
                        for (Account el : value) {
                            account = el;
                        }
                    } else {
                        System.out.println("Нет такого счета: " +  requisite);
                    }
                }
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
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
        int index1 = accl.indexOf(accl);
        System.out.println(index1);
    }
}

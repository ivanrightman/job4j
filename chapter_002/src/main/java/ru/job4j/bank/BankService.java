package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        /*was: List<Account> accounts = new ArrayList<>();
        this.users.putIfAbsent(user, accounts);*/
        this.users.computeIfAbsent(user, key -> new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !this.users.get(user).contains(account)) { //получить список по user и проверить по contains
            this.users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        /*was:User user = null;
        for (User el : users.keySet()) {
            if (el.getPassport().equals(passport)) {
                user = el;
                break;
            }
        }*/
        User user = this.users.keySet().stream().filter(el -> el.getPassport().equals(passport)).findFirst().orElse(null);
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        /*was: Account account = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = this.users.get(user);
            for (Account el : accounts) {
                if (el.getRequisite().contains(requisite)) {
                    account = el;
                    break;
                }
            }
        }
        return account;*/
        User user = findByPassport(passport);
        if (user != null) {
            Account account = this.users.get(user)
                    .stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst().orElse(null);
            return account;
        }
        return null;
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
    }
}

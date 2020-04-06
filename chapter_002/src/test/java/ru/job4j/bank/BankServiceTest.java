package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {
    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        User result = bank.findByPassport("3434");
        assertThat(result, is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        //Account result = bank.findByRequisite("34", "5546");
        assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    public void findByRequisiteReturnNull() {
        User user = new User("1223", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        Account result = bank.findByRequisite("1223", "8888");
        assertThat(result, is(nullValue()));
    }

    @Test
    public void findByRequisiteReturnAcc() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        Account account = new Account("5546", 150D);
        bank.addAccount(user.getPassport(), account);
        Account result = bank.findByRequisite("3434", "5546");
        assertThat(result, is(account));
    }


    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(200D));
    }

    @Test
    public void transferMoneyWhenNotEnoughMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        boolean result = bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 300D);
        assertThat(result, is(false));
    }

    @Test
    public void transferMoneyWhenSrcAccNotExist() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        boolean result = bank.transferMoney(user.getPassport(), "asdf", user.getPassport(), "113", 140D);
        assertThat(result, is(false));
    }

    @Test
    public void transferMoneyWhenDestAccNotExist() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        boolean result = bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "asgh", 130D);
        assertThat(result, is(false));
    }
}

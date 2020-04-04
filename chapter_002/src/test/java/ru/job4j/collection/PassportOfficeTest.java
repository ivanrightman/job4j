package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class PassportOfficeTest {

    @Test
    public void addUniqueIsTrue() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        assertThat(office.add(citizen), is(true));
    }

    @Test
    public void addCloneIsFalse() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenClone = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.add(citizenClone), is(false));
    }

    @Test
    public void getAddedClient() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Citizen result = office.get(citizen.getPassport());
        assertThat(result, is(citizen));
    }

    @Test
    public void getNotAddedClient() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        Citizen result = office.get(citizen.getPassport());
        assertThat(result, is(nullValue()));
    }

    @Test
    public void getAnotherNotAddedClient() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Citizen result = office.get("123");
        assertThat(result, is(nullValue()));
    }
}

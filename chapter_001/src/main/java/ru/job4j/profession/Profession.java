package ru.job4j.profession;

import ru.job4j.tracker.Predator;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public Profession(String name, String surname, String education, String birthday) {

    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public String getEducation() {
        return this.education;
    }
    public String getBirthday() {
        return this.birthday;
    }

    Dentist dentist = new Dentist("very bad");
    Surgeon surgeon = new Surgeon("implantation");
    Programmer programmer = new Programmer("Java");
    Builder builder = new Builder("construction");

}

package ru.job4j.profession;

public class Dentist extends Doctor {
    private String dentalType;

    public Dentist(String dentalType) {
        super(true, "veryBad");
    }
    public void dental() {
    }
}

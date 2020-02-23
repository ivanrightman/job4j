package ru.job4j.profession;

public class Surgeon extends Doctor {
    private String surgeryType;

    public Surgeon(String surgeryType) {
        super(false, "no finger");
    }
    public void surgeon() {
    }

}

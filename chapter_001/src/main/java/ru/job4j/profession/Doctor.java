package ru.job4j.profession;


public class Doctor extends Profession {
    private boolean phd;
    private String diagnose;

    public Doctor(boolean phd, String diagnose) {
        super("Steven", "Stevens", "Harvard", "10.10.1977");
    }

    public void getDiagnose() {
    }

    public void heal(Patient patient) {
    }
}

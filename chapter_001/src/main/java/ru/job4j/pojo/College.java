package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setLastName("Rightman");
        student.setName("Ivan");
        student.setMiddleName("No middle name");
        student.setGroup("Java");
        student.setEntered("17.12.2019");

        System.out.println("Student's last name: " + student.getLastName() + "; name: " + student.getName()
                        + "; middle name: " + student.getMiddleName() + "; group: " + student.getGroup()
                        + "; entered: " + student.getEntered());
    }
}

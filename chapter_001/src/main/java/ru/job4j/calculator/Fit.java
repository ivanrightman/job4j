package ru.job4j.calculator;

public class Fit {
    public static double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    public static double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
    public static void main(String[] args) {
        double manHeight = 180;
        double womanHeight = 165;
        double man = manWeight(manHeight);
        double woman = womanWeight(womanHeight);
        System.out.println("Man " + manHeight + " is " + man);
        System.out.println("Woman " + womanHeight + " is " + woman);
    }
}

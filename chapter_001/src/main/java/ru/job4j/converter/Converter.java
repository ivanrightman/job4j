package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {

        return value / 70;
    }

    public static int rubleToDollar(int value) {

        return value / 60;
    }

    public static int euroToRuble(int euroQuantity, int euroCourse) {

        return euroQuantity * euroCourse;
    }

    public static int dollarToRuble(int dollarQuantity, int dollarCourse) {
        return dollarQuantity * dollarCourse;
    }

    public static void main(String[] args) {
        int euroQuantity = 33;
        int euroCourse = 70;
        int dollarQuantity = 27;
        int dollarCourse = 60;
        int euro = rubleToEuro(140);
        int dollar = rubleToDollar(182);
        int rubleEuro = euroToRuble(euroQuantity, euroCourse);
        int rubleDollar = dollarToRuble(dollarQuantity, dollarCourse);
        System.out.println("140 rubles are " + euro + " euro.");
        System.out.println("120 rubles are " + dollar + " dollars.");
        System.out.println(euroQuantity + " euros are " + rubleEuro + " rubles.");
        System.out.println(dollarQuantity + " dollars are " + rubleDollar + " rubles.");

        //rubleToEuro_testStart
        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2. Test result : " + passed);
        //rubleToEuro_testEnd
        //rubleToDollar_testStart
        int in2 = 12;
        int expected2 = 3;
        int out2 = rubleToDollar(in2);
        boolean passed2 = expected2 == out2;
        System.out.println("120 rubles are 2. Test result : " + passed2);
        //rubleToDollar_testEnd
        //euroToRuble_testStart
        int inEuro3 = 33;
        int inCourse3 = 70;
        int expected3 = 2310;
        int out3 = euroToRuble(inEuro3, inCourse3);
        boolean passed3 = expected3 == out3;
        System.out.println(inEuro3 + " euros are " + expected3 + " rubles. Test result : " + passed3);
        //euroToRuble_testEnd
        //dollarToRuble_testStart
        int inDollar4 = 27;
        int inCourse4 = 60;
        int expected4 = 1620;
        int out4 = euroToRuble(inDollar4, inCourse4);
        boolean passed4 = expected4 == out4;
        System.out.println(inDollar4 + " dollars are " + expected4 + " rubles. Test result : " + passed4);
        //dollarToRuble_testEnd

    }
}
package ru.job4j.oop;

import java.sql.SQLOutput;

public class DummyDic {

    public String engToRus(String eng) {
        String phrase = "Неизвестное слово. ";
        return phrase + eng;
    }

    public static void main(String[] args) {
        String eng = "Flexibility";
        DummyDic dummydic = new DummyDic();
        System.out.println(dummydic.engToRus(eng));
    }
}

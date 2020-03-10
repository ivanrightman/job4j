package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул и отвечаю только на закрытые вопросы. Задай мне вопрос, на который можно овтетить Да или Нет ");
        String answer = input.nextLine();
        int variant = new Random().nextInt(3);
        //int variant = 0;
        String message = variant == 0 ? "Да" : (variant > 1 ? "Может быть" : "Нет");
        System.out.println(message);
    }
}

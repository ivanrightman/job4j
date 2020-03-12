package ru.job4j.io;

/**
 * В этом задании вам необходимо сделать игру 11. Смысл игры в следующем. На столе лежат 11 спичек. Два игрока по очереди берут от 1 до 3 спичек. Выигрывает тот, кто забрал последние спички.
 * 1. Создайте класс ru.job4j.io.Matches с методом main.
 * 2. В методе main добавьте цикл. Игра заканчивается, когда игрок забрал последние спички. В цикле нужно проверять количество спичек.
 * 3. Сделайте ввод данных от пользователя. По порядку. Сначала первый игрок вводит число от 1 до 3, потом второй и так далее.
 * Когда игрок ввел цифру, нужно показать сколько спичек осталось на столе.
 */

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matchesTotal = 11;
        int answerCount = 0;
        int matchesPlayerOne = 0;
        int matchesPlayerTWo = 0;

        while (true) {
            if (matchesTotal <= 0) {
                if (matchesPlayerOne > matchesPlayerTWo) {
                    System.out.println("Победил игрок 1");
                } else {
                    System.out.println("Победил игрок 2");
                }
                break;
            }
            System.out.println("Введите число от 1 до 3: ");
            int answer = Integer.valueOf(input.nextLine());
            if (answer < 0 || answer > 3) {
                System.out.println("Вы ввели неверное число, придется начать сначала :(");
                break;
            }
            if (answerCount % 2 == 0) {
                matchesPlayerOne++;
                answerCount++;
                matchesTotal -= answer;
                System.out.println("После ответа первого игрока на столе осталось " + matchesTotal + " спичек");
            } else {
                matchesPlayerTWo++;
                answerCount++;
                matchesTotal -= answer;
                System.out.println("После ответа второго игрока на столе осталось " + matchesTotal + " спичек");
            }
        }
    }
}

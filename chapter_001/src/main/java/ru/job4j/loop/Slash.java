/*
Для решение этой задачи вам нужно составить таблицу с индексами. По аналогии с задачей шахматная доска.
выражение для вычисления left и right будут отличаться.
Для вычисление left нужно использовать индексы row и cell.
Для вычисления right нужно использовать индексы row, cell и размер поля size. Помните, что мы начинаем считать с 0. Это нужно учитывать при вычислении переменной right.
Так же помните, что диагональ есть только в квадрате с нечетной длинной. Это условие проверять не надо.
Не гонитесь решить задачу целиком. Попробуйте начала нарисовать только одну диагональ с левого верхнего угла в правый нижний.
*/


package ru.job4j.loop;

public class Slash {
    public static void draw(int size) {
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                boolean left = row == cell;
                boolean right = size - 1 - row == cell;
                //row=0 cell=4; row=1 cell=2; row=3 cell=1; row=4 cell=0;
                if (left) {
                    System.out.print("0");
                }
                else if (right) {
                    System.out.print("0");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /*чтобы нарисовать только слева-направо:
                boolean left = row == cell; а в boolean right что угодно, чтобы оно было всегда false

     получился крест для 5, но для 3 не получился
                boolean left = (row + cell) %4 == 0; // добавить условие, по которому нужно определить ставить ли символ или нет.
                boolean right = (row - cell) %size == 0;


     */

    public static void main(String[] args) {
        System.out.println("Draw by 3");
        draw(3);
        System.out.println("Draw by 5");
        draw(5);
    }
}

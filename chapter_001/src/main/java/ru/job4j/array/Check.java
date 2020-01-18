package ru.job4j.array;
/*
3. Метод должен проверить, что все элементы в массиве являются или true или false.
Решение задачи сводится к проверки всех элементов с эталонным. Эталонным можно взять любой элемент в массиве.
Лучше взять элемент с индексом 0.
Например.
{true, true, true} - вернет true; массив однородный, он заполнен true.
{true, false, true} - вернет false; массив не однородный, он заполнен и true и false.
{false, false, false} - вернет true; массив однородный, он заполнен false.
4. В задании нельзя использовать дополнительный массив.

 */
public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == true && data[index-index] == true) {
                continue;
            }
            else if (data[index] == false && data[index-index] == false) {
                continue;
            }
            else if (data[index] == false && data[index-index] == true) {
                result = false;
            }
            else {
                result = false;
            }
        }
        return result;
    }
}

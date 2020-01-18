package ru.job4j.array;

public class ArrayChar {
    public static boolean startsWith(char[] word, char[] pref) {
        boolean result = false;
        for (int index = 0; index < (word.length - pref.length - 1); index++) {
            result = word[index] == pref[index];
            /*if (word[index] == pref[index]) {
                result = true;
            }
            else {
                result = false;
            }*/
        }
        return result;
    }
}

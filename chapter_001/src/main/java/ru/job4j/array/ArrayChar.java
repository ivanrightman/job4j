package ru.job4j.array;

public class ArrayChar {
    public static boolean startsWith(char[] word, char[] pref) {
        boolean result = false;
        for (int index = 0; index < pref.length; index++) {
            //result = word[index] == pref[index];
            if (word[index] != pref[index]) {
                result = false;
            }
            else {
                result = true;
            }
        }
        return result;
    }
}

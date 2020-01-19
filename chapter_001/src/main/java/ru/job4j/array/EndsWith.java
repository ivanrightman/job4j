package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = false;
        // проверить, что массив word имеет последние элементы одинаковые с post
        for (int index = 0; index < post.length; index++) {
            //result = word[index+word.length-post.length] == post[index];
            if (word[index+word.length-post.length] != post[index]) {
                result = false;

            }
            else {
                result = true;
            }
        }
        return result;
    }
}

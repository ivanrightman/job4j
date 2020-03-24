package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        if (rsl == -1) {
            throw new ElementNotFoundException();
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] stroki = {"stroka, strok2"};
        try {
            indexOf(stroki, "123");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }


}

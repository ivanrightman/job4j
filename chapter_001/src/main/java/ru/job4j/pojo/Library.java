package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book nature = new Book("Nature", 1000);
        Book math = new Book("Mathematics", 1200);
        Book lit = new Book("Pushkin", 2000);
        Book code = new Book("Clean code", 1000);

        Book[] shelf = new Book[4];

        shelf[0] = nature;
        shelf[1] = math;
        shelf[2] = lit;
        shelf[3] = code;

        for (int i = 0; i < shelf.length; i++) {
            Book sh = shelf[i];
            System.out.println("Book name: " + sh.getName() + "; Sheets total: " + sh.getSheets());
        }

        Book tmp = shelf[0];
        shelf[0] = shelf[3];
        shelf[3] = tmp;

        for (int i = 0; i < shelf.length; i++) {
            Book sh = shelf[i];
            System.out.println("Perestanovka_start" + "Book name: " + sh.getName() + "; Sheets total: " + sh.getSheets());
        }

        for (int i = 0; i < shelf.length; i++) {
            Book sh = shelf[i];
            if (sh.getName().equals("Clean code")) {
                System.out.println("OnlyCleanCode_start..." + "Book name: " + sh.getName() + "; Sheets total: " + sh.getSheets());
            }

        }
    }
}

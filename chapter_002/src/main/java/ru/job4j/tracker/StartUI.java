package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Item name: " + item.getName() + "; Item id: " + item.getId());
            } else if (select == 1) {
                Item[] findAll = tracker.findAll();
                System.out.println("=== Showing all items ====");
                for (int i = 0; i < findAll.length; i++) {
                    Item item1 = findAll[i];
                    System.out.println("Item name: " + item1.getName() + "; Item id: " + item1.getId());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item name ====");
                System.out.print("Enter item id you want to edit: ");
                String itemId = scanner.nextLine();
                System.out.print("Enter new item name: ");
                String newName = scanner.nextLine();
                Item item = new Item(newName);
                if (tracker.replace(itemId, item)) {
                    System.out.println("New item name has been added to this id");
                } else {
                    System.out.println("Something went wrong. New item name has NOT been added to this id. Maybe because of illegal id");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter item id: ");
                String currentItemId = scanner.nextLine();
                if (tracker.delete(currentItemId)) {
                    System.out.println("Item has been deleted");
                } else {
                    System.out.println("Something went wrong. Item has NOT been deleted. Maybe because of illegal id");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ====");
                System.out.print("Enter item id: ");
                String itemId = scanner.nextLine();
                Item item = tracker.findById(itemId);
                System.out.println("Item name: " + item.getName() + "; Item id: " + item.getId());
            } else if (select == 5) {
                System.out.println("=== Find item by name ====");
                System.out.print("Enter item name: ");
                String itemName = scanner.nextLine();
                Item[] items = tracker.findByName(itemName);
                for (int i = 0; i < items.length; i++) {
                    Item item1 = items[i];
                    System.out.println("Item name: " + item1.getName() + "; Item id: " + item1.getId());
                }
            } else if (select == 6) {
                run = false;
                System.out.println("Goodbye");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu: ");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}

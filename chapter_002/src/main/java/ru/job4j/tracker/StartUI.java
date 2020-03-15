package ru.job4j.tracker;


public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item name: " + item.getName() + "; Item id: " + item.getId());
    }

    public static void showAllItems(Input input, Tracker tracker) {
        Item[] findAll = tracker.findAll();
        System.out.println("=== Showing all items ====");
        for (int i = 0; i < findAll.length; i++) {
            Item item1 = findAll[i];
            System.out.println("Item name: " + item1.getName() + "; Item id: " + item1.getId());
        }
    }
    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item name ====");
        String itemId = input.askStr("Enter item id you want to edit: ");
        String newName = input.askStr("Enter new item name: ");
        Item item = new Item(newName);
        if (tracker.replace(itemId, item)) {
            System.out.println("New item name has been added to this id");
        } else {
            System.out.println("Something went wrong. New item name has NOT been added to this id. Maybe because of illegal id");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String currentItemId = input.askStr("Enter item id: ");
        if (tracker.delete(currentItemId)) {
            System.out.println("Item has been deleted");
        } else {
            System.out.println("Something went wrong. Item has NOT been deleted. Maybe because of illegal id");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ====");
        String itemId = input.askStr("Enter item id: ");
        Item item = tracker.findById(itemId);
        System.out.println("Item name: " + item.getName() + "; Item id: " + item.getId());
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ====");
        String itemName = input.askStr("Enter item name: ");
        Item[] items = tracker.findByName(itemName);
        for (int i = 0; i < items.length; i++) {
            Item item1 = items[i];
            System.out.println("Item name: " + item1.getName() + "; Item id: " + item1.getId());
        }
    }

    public static boolean start() {
        return true;
    }

    public static boolean exit() {
        System.out.println("Goodbye");
        return false;
    }

    public void init(Input input, Tracker tracker) {
        boolean run = StartUI.start();
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(input, tracker);
            } else if (select == 2) {
               StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = StartUI.exit();
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}

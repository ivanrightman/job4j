package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemId = input.askStr("Enter item id you want to edit: ");
        String newName = input.askStr("Enter new item name: ");
        Item item = new Item(newName);
        if (tracker.replace(itemId, item)) {
            System.out.println("New item name has been added to this id");
        } else {
            System.out.println("Something went wrong. New item name has NOT been added to this id. Maybe because of illegal id");
        }
        return true;
    }
}

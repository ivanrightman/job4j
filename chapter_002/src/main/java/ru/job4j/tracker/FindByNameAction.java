package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemName = input.askStr("Enter item name: ");
        System.out.println("=== Find item by name ====");
        //was:Item[] items = tracker.findByName(itemName);
        List<Item> items = tracker.findByName(itemName);
        //was: if (items.length == 0) {
        if (items.size() == 0) {
            System.out.println("Item NOT found. Maybe because of illegal name");
        } //was: else if (items.length > 0) {
        else if (items.size() > 0) {
            //was: for (int i = 0; i < items.length; i++) {
            for (Item el : items) {
                //was: Item item1 = items[i];
                items.add(el);
                System.out.println("Item name: " + el.getName() + "; Item id: " + el.getId());
            }
        }
        return true;
    }
}

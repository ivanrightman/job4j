package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemName = input.askStr("Enter item name: ");
        System.out.println("=== Find item by name ====");
        Item[] items = tracker.findByName(itemName);
        if (items.length == 0) {
            System.out.println("Item NOT found. Maybe because of illegal name");
        } else if (items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                Item item1 = items[i];
                System.out.println("Item name: " + item1.getName() + "; Item id: " + item1.getId());
            }
        }
        return true;
    }
}

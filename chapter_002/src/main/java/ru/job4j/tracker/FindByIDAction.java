package ru.job4j.tracker;

public class FindByIDAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemId = input.askStr("Enter item id: ");
        Item item = tracker.findById(itemId);
        if (item != null) {
            System.out.println("Item name: " + item.getName() + "; Item id: " + item.getId());
        } else {
            System.out.println("Item NOT found. Maybe because of illegal id");
        }
        return true;
    }
}

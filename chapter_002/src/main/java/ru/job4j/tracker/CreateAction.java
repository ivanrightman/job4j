package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        if (item != null) {
            System.out.println("Item name: " + item.getName() + "; Item id: " + item.getId());
        } else {
            System.out.println("Something went wrong. Please try again");
        }
        return true;
    }
}

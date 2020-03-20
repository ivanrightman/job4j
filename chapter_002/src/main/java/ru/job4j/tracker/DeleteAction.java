package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String currentItemId = input.askStr("Enter item id: ");
        if (tracker.delete(currentItemId)) {
            System.out.println("Item has been deleted");
        } else {
            System.out.println("Something went wrong. Item has NOT been deleted. Maybe because of illegal id");
        }
        return true;
    }
}

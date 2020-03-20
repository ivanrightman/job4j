package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "=== Showing all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] findAll = tracker.findAll();
        System.out.println("=== Showing all items ====");
        if (findAll.length == 0) {
            System.out.println("Nothing to show. There are no items yet");
        } else if (findAll.length > 0) {
            for (int i = 0; i < findAll.length; i++) {
                Item item1 = findAll[i];
                System.out.println("Item name: " + item1.getName() + "; Item id: " + item1.getId());
            }
        }
        return true;
    }
}

package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "=== Showing all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        //was:Item[] findAll = tracker.findAll();
        List<Item> findAll = tracker.findAll();
        System.out.println("=== Showing all items ====");
        //was: if (findAll.length == 0) {
        if (findAll.size() == 0) {
            System.out.println("Nothing to show. There are no items yet");
        } //else if (findAll.length > 0) {
        else if (findAll.size() > 0) {
            //was: for (int i = 0; i < findAll.length; i++) {
            for (Item el : findAll) {
                //was: Item item1 = findAll[i];
                findAll.add(el);
                //was: System.out.println("Item name: " + item1.getName() + "; Item id: " + item1.getId());
                System.out.println("Item name: " + el.getName() + "; Item id: " + el.getId());
            }
        }
        return true;
    }
}


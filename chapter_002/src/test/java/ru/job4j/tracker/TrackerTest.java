package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);;
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }


    @Test
    public void addNewItemInArrayThenTrackerHasSameItemInArray() {
        Tracker tracker = new Tracker();
        //was: Item[] items = new Item[3];
        List<Item> items = new ArrayList<>();
        //was: items[0] = new Item("Test3");
        Item testItem = new Item("Test3");
        items.add(testItem);
        //was: tracker.add(items[0]);
        tracker.add(testItem);
        //was: String item1 = items[0].getName();
        String item1 = testItem.getName();
        //was: Item[] result = tracker.findByName(item1);
        List<Item> result = tracker.findByName(item1);
        //was: Item[] expected = {items[0]};
        List<Item> expected = items;
        assertThat(result, is(expected));
    }

    @Test
    public void findAllDontReturnNullItem() {
        Tracker tracker = new Tracker();
        /*was: Item[] items = new Item[2];
        items[0] = new Item("Test5");
        items[1] = new Item(null);
        tracker.add(items[0]);
        Item[] result = tracker.findAll();
        Item[] expected = {items[0]};
         */
        List<Item> items = new ArrayList<>();
        Item testItem = new Item("Test5");
        Item testItemNull = new Item(null);
        items.add(testItem);
        items.add(testItemNull);
        tracker.add(testItem);
        tracker.add(testItemNull);
        List<Item> result = tracker.findAll();
        List<Item> expected = items;
        assertThat(result, is(expected));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenNotReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("item");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace("1", bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("item"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenNotDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete("1");
        assertThat(tracker.findById(id).getName(), is("Bug"));
    }
}

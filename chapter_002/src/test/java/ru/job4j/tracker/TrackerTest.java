package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        //Item item2 = new Item("test2");
        //Item item3 = new Item(null);
        tracker.add(item);
        //tracker.add(item2);
        //tracker.add(item3);
        Item result = tracker.findById(item.getId());
        //Item result2 = tracker.findById(item2.getId());
        //Item result3 = tracker.findById((item3.getId()));
        assertThat(result.getName(), is(item.getName()));
        //assertThat(result2.getName(), is(item2.getName()));
        //assertThat(result3.getName(), is(item3.getName()));
    }


    @Test
    public void addNewItemInArrayThenTrackerHasSameItemInArray() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[3];
        items[0] = new Item("Test3");
        //items[1] = new Item("Test4");
        //items[2] = new Item("Test5");
        tracker.add(items[0]);
        //tracker.add(items[1]);
        //tracker.add(items[2]);
        String item1 = items[0].getName();
        //String item2 = items[1].getName();
        //String item3 = items[2].getName();
        Item[] result = tracker.findByName(item1); // как в result записать результат tracker.findByName(item2) и item3 ?
        Item[] expected = {items[0]}; // чтобы сюда добавить {items[0], items[1], items[2]}, чтобы тест прошел
        assertThat(result, is(expected));
    }

    @Test
    public void findAllDontReturnNullItem() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[2];
        items[0] = new Item("Test5");
        items[1] = new Item(null);
        tracker.add(items[0]);
        Item[] result = tracker.findAll();
        Item[] expected = {items[0]};
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
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace("1", bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug"));
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

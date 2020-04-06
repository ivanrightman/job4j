package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemTest {

    @Test
    public void sortAsc() {
        Item item1 = new Item("trulyalya");
        Item item2 = new Item("item1");
        Item item3 = new Item("tratata");
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Collections.sort(items);
        List<String> result = Arrays.asList(items.get(0).getName(), items.get(1).getName(), items.get(2).getName());
        List<String> expected = Arrays.asList("item1", "tratata", "trulyalya");
        assertThat(result, is(expected));
    }

    @Test
    public void sortDesc() {
        Item item1 = new Item("trulyalya");
        Item item2 = new Item("item1");
        Item item3 = new Item("tratata");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Collections.sort(items, new SortReverse());
        List<String> result = Arrays.asList(items.get(0).getName(), items.get(1).getName(), items.get(2).getName());
        List<String> expected = Arrays.asList("trulyalya", "tratata", "item1");
        assertThat(result, is(expected));
    }

}

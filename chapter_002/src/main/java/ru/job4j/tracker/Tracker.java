package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    //was: private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
    //was: private int position = 0;

      /**
     * Метод добавления заявки в хранилище
     * Метод public Item add(Item item) добавляет заявку, переданную в аргументах в массив заявок this.items;
     * В методе add нужно проставить уникальный ключ в объект Item item. Это нужно сделать через метод setId.
     * Уникальный ключ нужно генерировать на основании времени и произвольного числа.
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        //was: items[this.position++] = item;
        items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    private int indexOf(String id) {
        int rsl = -1;
        /*was: for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                rsl = i;
                break;
            }
        }*/
        for (Item el : this.items) {
            if (el.getId().equals(id)) {
                rsl = this.items.indexOf(el);
                break;
            }
        }
        return rsl;
    }
    /**
     * Метод public Item[] findAll() возвращает копию массива this.items без null элементов (без пустых клеток).
     * @return
     */
    //was: public Item[] findAll() {
    public List<Item> findAll() {
        //was: return Arrays.copyOf(items, position);
        /*Item[] tmp = Arrays.copyOf(items, position);
        for (int i = 0; i < position; i++) {
            if (this.items[i].getName() != null && this.items[i].getId() != null) {
                tmp[i] = this.items[i];
            }
        }
        return tmp;*/
        return this.items;
    }

    /**
     * Метод public Item[] findByName(String key) проверяет в цикле все элементы
     * массива this.items, сравнивая name (используя метод getName класса Item)
     * с аргументом метода String key.
     * * Элементы, у которых совпадает name, копирует в результирующий массив и
     * возвращает его. Алгоритм этого метода аналогичен методу findAll.
     * @return
     */
    //was: public Item[] findByName(String key) {
    public List<Item> findByName(String key) {
        /*was: Item[] tmp = new Item[position];
        int size = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getName().equals(key)) {
                tmp[i] = this.items[i];
                size++;
            }
        }
        return Arrays.copyOf(tmp, size);*/
        List<Item> tmp = new ArrayList();
        for (Item el : this.items) {
            if (el.getName().equals(key)) {
                tmp.add(el);
            }
        }
        return tmp;
    }

    /**
     * Метод public Item findById(String id) проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     * @return
     */
    public Item findById(String id) {
        int index = indexOf(id);
        //was: return index != -1 ? items[index] : null;
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        item.setId(id);
        if (index != -1) {
            //was: items[index] = item;
            items.set(index, item);
        }
        return index != -1 ? true : false;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        if (index != -1) {
            int start = index + 1;
            int distPos = index;
            /*was: int size = position - index;
            System.arraycopy(items, start, items, distPos, size);
            items[position - 1] = null;
            position--;*/
            items.remove(index);
        }
        return index != -1 ? true : false;
    }
}


package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

      /**
     * Метод добавления заявки в хранилище
     * Метод public Item add(Item item) добавляет заявку, переданную в аргументах в массив заявок this.items;
     * В методе add нужно проставить уникальный ключ в объект Item item. Это нужно сделать через метод setId.
     * Уникальный ключ нужно генерировать на основании времени и произвольного числа.
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[this.position++] = item;
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
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
    /**
     * Метод public Item[] findAll() возвращает копию массива this.items без null элементов (без пустых клеток).
     * @return
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
        /*Item[] tmp = Arrays.copyOf(items, position);
        for (int i = 0; i < position; i++) {
            if (this.items[i].getName() != null && this.items[i].getId() != null) {
                tmp[i] = this.items[i];
            }
        }
        return tmp;*/
    }

    /**
     * Метод public Item[] findByName(String key) проверяет в цикле все элементы
     * массива this.items, сравнивая name (используя метод getName класса Item)
     * с аргументом метода String key.
     * * Элементы, у которых совпадает name, копирует в результирующий массив и
     * возвращает его. Алгоритм этого метода аналогичен методу findAll.
     * @return
     */
    public Item[] findByName(String key) {
        Item[] tmp = new Item[position];
        int size = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getName().equals(key)) {
                tmp[i] = this.items[i];
                size++;
            }
        }
        return Arrays.copyOf(tmp, size);
    }

    /**
     * Метод public Item findById(String id) проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     * @return
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        item.setId(id);
        items[index] = item;
        return index != -1 ? true : false;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        int start = index + 1;
        int distPos = index;
        int size = position - index;
        System.arraycopy(items, start, items, distPos, size);
        items[position - 1] = null;
        position--;
        return position != -1 ? true : false;
    }
}


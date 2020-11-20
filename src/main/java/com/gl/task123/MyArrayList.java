package com.gl.task123;

import java.util.Arrays;

public class MyArrayList<E> {

    public static final int INITIAL_CAPACITY = 10;

    private int currentSize;

    private E[] items;

    public MyArrayList() {
        currentSize = 0;
        checkSize(INITIAL_CAPACITY);
    }

    private void checkSize(int newCapacity) {
        E[] newList = (E[]) new Object[newCapacity];
        if (items != null) {
            System.arraycopy(items, 0, newList, 0, currentSize);
        }
        items = newList;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();

        return items[index];
    }

    public int size() {
        return currentSize;
    }

    @Override
    public String toString() {
        return Arrays.asList(Arrays.copyOfRange(items, 0, size())).toString();
    }

    public void add(E element) {
        if (items.length == currentSize) {
            checkSize((items.length * 3) / 2 + 1);
        }
        items[currentSize] = element;
        currentSize++;
    }

    public void add(int index, E element) {
        if (items.length == currentSize) {
            checkSize((items.length * 3) / 2 + 1);
        }
        System.arraycopy(items, index, items, index + 1, currentSize - index);
        items[index] = element;
        currentSize++;
    }


    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        E oldElement = items[index];

        for (int i = index; i < currentSize - 1; i++) {
            items[i] = items[i + 1];
            items[i + 1] = null;
        }

        currentSize--;
        return oldElement;
    }

    public E set(int index, E newVal) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        E oldElement = items[index];
        items[index] = newVal;
        return oldElement;
    }
}

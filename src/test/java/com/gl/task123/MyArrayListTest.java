package com.gl.task123;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private static MyArrayList<Integer> integers;

    @BeforeEach
    void setUp() {
        integers = new MyArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
    }

    @Test
    void get() {
        Integer integer = integers.get(2);
        Assertions.assertEquals(Integer.valueOf(3), integer);
    }

    @Test
    void add() {
        integers.add(1000);
        assertEquals(integers.get(5), Integer.valueOf(1000));

    }

    @Test
    void addWithIndex() {
        integers.add(1, 5000);
        assertEquals(integers.get(1), Integer.valueOf(5000));
    }

    @Test
    void remove() {
        int initialSize = integers.size();
        integers.remove(0);
        assertEquals(5, initialSize);

    }

    @Test
    void set() {
        integers.set(2, 1_000_000);
        assertEquals(Integer.valueOf(1_000_000), integers.get(2));
    }

    @Test
    void getExceptionWhileRemoving() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
                integers.remove(100);
        });
    }
}
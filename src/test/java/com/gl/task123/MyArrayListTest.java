package com.gl.task123;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    private static MyArrayList<Integer> integers;

    @Before
    public void setUp() throws Exception{
        integers = new MyArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
    }

    @Test
    public void get() {
        Integer integer = integers.get(2);
        assertEquals(Integer.valueOf(3), integer);
    }

    @Test
    public void add() {
        integers.add(1000);
        assertEquals(integers.get(5), Integer.valueOf(1000));

    }

    @Test
    public void addWithIndex() {
        integers.add(1, 5000);
        assertEquals(integers.get(1), Integer.valueOf(5000));
    }

    @Test
    public void remove() {
        int initialSize = integers.size();
        integers.remove(0);
        assertEquals(5, initialSize);

    }

    @Test
    public void set() {
        integers.set(2, 1_000_000);
        assertEquals(Integer.valueOf(1_000_000), integers.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceptionWhileRemoving() {
            integers.remove(100);
    }
}
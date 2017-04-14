package test2;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testGetAll() throws Exception {
        assertEquals(Arrays.asList(1, 2, 3, 4),
                Item.newInstance(Item.newInstance(Item.newInstance(1), Item.newInstance(2), Item.newInstance(Item.newInstance(3))),
                        Item.newInstance(4)).getAll());

        assertEquals(Arrays.asList("one", "two", "three", "four"),
                Item.newInstance(
                        Item.newInstance(Item.newInstance(Item.newInstance("one"))),
                        Item.newInstance(Item.newInstance(Item.newInstance("two"), Item.newInstance("three")),
                                Item.newInstance("four"))).getAll());

        assertEquals(Arrays.asList(2F), Item.newInstance(2F).getAll());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("[1, 2, 3, 4]", Item.newInstance(
                Item.newInstance(Item.newInstance(1), Item.newInstance(2), Item.newInstance(Item.newInstance(3))),
                Item.newInstance(4)).getAll().toString());
        assertEquals("hi", Item.newInstance("hi").toString());
    }

    @Test
    public void testNewInstance() throws Exception {

    }

    @Test
    public void testNewInstance1() throws Exception {

    }

    @Test
    public void testNewInstance2() throws Exception {

    }
}
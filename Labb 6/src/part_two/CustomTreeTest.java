package part_two;

import static org.junit.Assert.*;
import org.junit.Test;

public class CustomTreeTest {


    @Test
    public void testEmpty() {
        //krav 1
        CustomTreeMap<Integer> vec = new CustomTreeMap<>();
        assertEquals(0, vec.size());
        assertEquals(-1, vec.minIndex());
        assertNull(vec.get(3));
        assertNull(vec.sortedValues());
        assertNull(vec.toArray());
    }

    @Test
    public void testIndexAddRemove() {
        CustomTreeMap<Integer> vec = new CustomTreeMap<>();

        // Test add with specifying position
        vec.add(0, 1900);
        assertEquals(1, vec.size());
        vec.add(1, 1901);
        assertEquals(2, vec.size());
        vec.add(50, 2079);
        assertEquals(3, vec.size());

        // Test add on existing
        vec.add(50, 1500);
        assertEquals(3, vec.size());
        assertEquals(0, vec.minIndex());
        assertEquals(50, vec.maxIndex());

        // Test add without specifying position
        vec.add(5000);
        assertEquals(4, vec.size());
        assertEquals(5000, vec.get(2).intValue());
        assertNull(vec.get(19));

        // Test remove by specifying index
        vec.removeAt(0);
        assertEquals(3, vec.size());
        assertEquals(1, vec.minIndex());
        assertEquals(50, vec.maxIndex());

        // Test remove without specifying index
        vec.removeElem(2079);
        assertEquals(3, vec.size());
        assertEquals(50, vec.maxIndex());
        assertNull(vec.get(17));
    }

    @Test
    public void testString() {
        CustomTreeMap<String> vec = new CustomTreeMap<>();
        vec.add(0, "Hello");
        vec.add(1, "All");
        assertEquals(0, vec.indexOf("Hello"));
        assertEquals("Hello", vec.get(0));
    }

}

package part_two;


import static org.junit.Assert.*;
import org.junit.Test;

public class VectorATest {
    @Test
    /* Krav 1 */
    public void testEmpty() {
        //krav 1
        VectorA<Integer> vec = new VectorA<>();
        assertEquals(0, vec.size());
        assertEquals(-1, vec.minIndex());
        assertNull(vec.get(3));
        assertNull(vec.sortedValues());
        assertNull(vec.toArray());
    }

    @Test
    public void testIndexAddRemove(){
        VectorA<Integer> vec = new VectorA<>();

        // Test add by specifying position

        vec.add(0, 1900);
        assertEquals(1, vec.size());

        vec.add(1, 1981);
        assertEquals(2,vec.size());

        vec.add(50, 2079);
        assertEquals(3, vec.size());

        //Test add on existing position
        vec.add(50, 1500);
        assertEquals(3, vec.size());
        assertEquals(0, vec.minIndex());
        assertEquals(50, vec.maxIndex());
        assertEquals(1500, vec.get(50).intValue());



        //test add without specifying position
        vec.add(5000);
        assertEquals(4, vec.size());
        assertEquals(5000, vec.get(2).intValue());
        assertNull(vec.get(19));

        // test remove by specifying index
        vec.removeAt(0);
        assertEquals(3, vec.size());
        assertEquals(1, vec.minIndex());
        assertEquals(50, vec.maxIndex());

        //test remove without specifying index

        vec.removeElem(2079);
        assertEquals(3, vec.size());
        assertEquals(50, vec.maxIndex());
        assertNull(vec.get(17));
    }


    @Test
    public void testString(){
        VectorA<String> vec = new VectorA<>();
        vec.add(0, "Hello");
        vec.add(1, "All");
        assertEquals(0, vec.indexOf("Hello"));
        assertEquals("Hello", vec.get(0));
    }
}
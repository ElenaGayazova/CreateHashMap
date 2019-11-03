package mycollection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void size() {
        MyHashMap map = new MyHashMap();

        assertEquals(0, map.size());

        map.put("first","value1");
        assertEquals(1, map.size());
    }

    @Test
    public void isEmpty() {
        MyHashMap map = new MyHashMap();

        assertEquals(true, map.isEmpty());

        map.put("first","value1");
        assertEquals(false, map.isEmpty());
    }

    @Test
    public void containsKey() {
        MyHashMap map = new MyHashMap();
        map.put("first","value1");

        assertEquals(true, map.containsKey("first"));
        assertEquals(false, map.containsKey("second"));

        map.clear();
        assertEquals(false, map.containsKey("first"));
    }

    @Test
    public void containsValue() {
        MyHashMap map = new MyHashMap();
        map.put("first","value1");

        assertEquals(true, map.containsValue("value1"));
        assertEquals(false, map.containsValue("value2"));

        map.clear();
        assertEquals(false, map.containsValue("value1"));
    }

    @Test
    public void get() {
        MyHashMap map = new MyHashMap();
        map.put("first","value1");

        assertEquals("value1", map.get("first"));
        assertEquals(null, map.get("second"));
    }

    @Test
    public void put() {
        MyHashMap map = new MyHashMap();
        assertEquals(null, map.get("first"));
        map.put("first","value1");
        assertEquals("value1", map.get("first"));
        map.put("first","value2");
        assertEquals("value2", map.get("first"));

        assertEquals(1, map.size());
    }

    @Test
    public void remove() {
        MyHashMap map = new MyHashMap();
        assertEquals(null, map.get("first"));
        map.put("first","value1");
        assertEquals("value1", map.get("first"));
        map.remove("first");
        assertEquals(null, map.get("first"));

        assertEquals(0, map.size());
    }

    @Test
    public void clear() {
        MyHashMap map = new MyHashMap();
        map.put("first","value1");

        assertEquals(1, map.size());

        map.clear();

        assertEquals(0, map.size());
    }
}
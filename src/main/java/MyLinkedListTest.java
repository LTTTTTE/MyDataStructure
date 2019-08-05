import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void testInstance() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();
        assertNotNull(myLinkedList);
        assertEquals(myLinkedList.toString(), "[]");
    }

    @Test
    public void testAdd() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(100);
        myLinkedList.add(200);
        myLinkedList.add(300);

        assertEquals(myLinkedList.size(), 3);
        assertEquals(myLinkedList.toString(), "[100, 200, 300]");
    }

    @Test
    public void testAddFirst() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(20);
        myLinkedList.addFirst(30);
        myLinkedList.addFirst(40);

        assertEquals(myLinkedList.size(), 4);
        assertEquals(myLinkedList.toString(), "[40, 30, 20, 10]");
    }

    @Test
    public void testAddIndex() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(20);
        myLinkedList.add(40);
        myLinkedList.add(1, 30);
        myLinkedList.add(0, 10);
        myLinkedList.add(4, 50);


        assertEquals(myLinkedList.size(), 5);
        assertEquals(myLinkedList.toString(), "[10, 20, 30, 40, 50]");
    }

    @Test
    public void testIndexOf() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);
        myLinkedList.add(40);
        myLinkedList.add(50);

        assertEquals(myLinkedList.indexOf(10), 0);
        assertEquals(myLinkedList.indexOf(20), 1);
        assertEquals(myLinkedList.indexOf(30), 2);
        assertEquals(myLinkedList.indexOf(40), 3);
        assertEquals(myLinkedList.indexOf(50), 4);
        assertEquals(myLinkedList.indexOf(9999), -1);
    }

    @Test
    public void testLastIndexOf() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);
        myLinkedList.add(40);
        myLinkedList.add(50);

        assertEquals(myLinkedList.lastIndexOf(10), 0);
        assertEquals(myLinkedList.lastIndexOf(20), 1);
        assertEquals(myLinkedList.lastIndexOf(30), 2);
        assertEquals(myLinkedList.lastIndexOf(40), 3);
        assertEquals(myLinkedList.lastIndexOf(50), 4);
        assertEquals(myLinkedList.lastIndexOf(9999), -1);
    }

    @Test
    public void testContains() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(10);
        myLinkedList.add(20);

        assertTrue(myLinkedList.contains(20));
        assertTrue(myLinkedList.contains(10));
        assertFalse(myLinkedList.contains(9999));
    }

    @Test
    public void testGet() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(1000);
        myLinkedList.add(2000);
        myLinkedList.add(3000);

        assertEquals(myLinkedList.get(2), 3000);
        assertEquals(myLinkedList.get(0), 1000);
    }

    @Test
    public void testSet() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(1000);
        myLinkedList.add(2000);
        myLinkedList.add(3000);

        assertEquals(myLinkedList.set(2, 9000), myLinkedList.get(2));
        assertEquals(myLinkedList.get(2), 9000);
    }

    @Test
    public void testClear() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(1000);
        myLinkedList.add(2000);
        myLinkedList.add(3000);

        myLinkedList.clear();
        assertEquals(myLinkedList.size(), 0);
        assertTrue(myLinkedList.isEmpty());

        myLinkedList.add(10);
        assertEquals(myLinkedList.toString(), "[10]");
    }

    @Test
    public void testRemoveFirst() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(1000);
        myLinkedList.add(2000);
        myLinkedList.add(3000);

        myLinkedList.removeFirst();

        assertEquals(myLinkedList.size(), 2);
        assertEquals(myLinkedList.toString(), "[2000, 3000]");

    }

    @Test
    public void testRemoveLast() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(100);
        myLinkedList.add(200);
        myLinkedList.add(300);
        myLinkedList.add(400);

        myLinkedList.removeLast();

        assertEquals(myLinkedList.size(), 3);
        assertEquals(myLinkedList.toString(), "[100, 200, 300]");

    }

    @Test
    public void testRemoveIndex() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(100);
        myLinkedList.add(200);
        myLinkedList.add(300);
        myLinkedList.add(400);
        myLinkedList.add(500);

        myLinkedList.remove(3);

        assertEquals(myLinkedList.size(),4);
        assertEquals(myLinkedList.toString(),"[100, 200, 300, 500]");

    }

    @Test
    public void testRemoveData(){
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(100);
        myLinkedList.add(200);
        myLinkedList.add(300);
        myLinkedList.add(400);
        myLinkedList.add(500);

        myLinkedList.remove((Object)400);

        assertEquals(myLinkedList.size(),4);
        assertEquals(myLinkedList.toString(),"[100, 200, 300, 500]");
    }

    @Test
    public void testContainsAll(){
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(100);
        myLinkedList.add(200);
        myLinkedList.add(300);
        myLinkedList.add(400);
        myLinkedList.add(500);

        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);

        assertTrue(myLinkedList.containsAll(list));

        list.add(9999);
        assertFalse(myLinkedList.containsAll(list));
    }

    @Test
    public void testAddAll(){
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(100);
        myLinkedList.add(200);
        myLinkedList.add(300);
        myLinkedList.add(400);
        myLinkedList.add(500);

        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);

        myLinkedList.addAll(list);

        assertEquals(myLinkedList.size(),8);
        assertEquals(myLinkedList.toString(),"[100, 200, 300, 400, 500, 100, 200, 300]");
    }

    @Test
    public void testAddAllIndex(){
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(100);
        myLinkedList.add(200);
        myLinkedList.add(300);
        myLinkedList.add(400);
        myLinkedList.add(500);

        List<Integer> list = new ArrayList<>();
        list.add(1000);
        list.add(2000);
        list.add(3000);

        assertTrue(myLinkedList.addAll(2, list));
        assertEquals(myLinkedList.toString(),"[100, 200, 1000, 2000, 3000, 300, 400, 500]");
    }

    @Test
    public void testRemoveAll(){
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(100);
        myLinkedList.add(200);
        myLinkedList.add(300);
        myLinkedList.add(400);
        myLinkedList.add(500);
        myLinkedList.add(600);
        myLinkedList.add(700);

        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(300);
        list.add(600);

        assertTrue(myLinkedList.removeAll(list));
        assertEquals(myLinkedList.size(),4);
        assertEquals(myLinkedList.toString(),"[200, 400, 500, 700]");
    }
}
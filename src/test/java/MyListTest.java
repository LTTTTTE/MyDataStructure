import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class MyListTest {

    @Test
    public void testMyListNotNull(){
        MyList<String> myList = new MyList<>();
        assertNotNull(myList);
    }

    @Test
    public void testMyListAdd(){
        MyList<String> myList = new MyList<>();
        myList.add("Hello");
        myList.add("World");
        assertEquals(myList.size(),2);
    }

    @Test
    public void testMyListAddIndex(){
        MyList<String> myList = new MyList<>();
        myList.add("Hello");
        myList.add("World");
        myList.add(1,"Java");
        assertEquals(myList.get(1),"Java");
    }

    @Test
    public void testMyListAddAll(){
        List<String> stringList = new ArrayList<>();
        MyList<String> myList = new MyList<>();

        stringList.add("Hello");
        stringList.add("World");

        myList.addAll(stringList);
        assertEquals(myList.size(),2);

    }

    @Test
    public void testMyListContains(){
        MyList<String> myList = new MyList<>();
        myList.add("hell");
        myList.add("ass");
        assertTrue(myList.contains("hell"));
    }

    @Test
    public void testMyListAddAllIndex(){
        List<String> stringList = new ArrayList<>();
        MyList<String> myList = new MyList<>();

        stringList.add("Hello");
        stringList.add("World");
        myList.add("A");
        myList.add("B");
        myList.add("C");

        assertTrue(myList.addAll(1,stringList));
        assertEquals(myList.size(),5);
    }

    @Test
    public void testMyListIndexOf(){
        MyList<String> myList = new MyList<>();
        myList.add("Hello");
        myList.add("World");
        myList.add("Hi");
        myList.add("Java");

        assertEquals(myList.indexOf("Java"),3);
    }

    @Test
    public void testMyListLastIndexOf(){
        MyList<String> myList = new MyList<>();
        myList.add("Hello");
        myList.add("World");
        myList.add("Hi");
        myList.add("Java");
        myList.add("Java");
        myList.add("Java");
        myList.add("Java");

        assertEquals(myList.lastIndexOf("Java"),6);
    }

    @Test
    public void testMyListRemove(){
        MyList<String> myList = new MyList<>();
        myList.add("Hello");
        myList.add("World");
        myList.add("Hi");
        myList.add("Java");
        myList.add("Android");
        myList.add("Hello_123");
        myList.add("World_123");
        myList.add("Hi_123");
        myList.add("Java_123");
        myList.add("Android_123");

        assertTrue(myList.remove("Hello"));
        assertTrue(myList.remove("Android_123"));
        assertTrue(myList.remove("Hi"));
        assertTrue(myList.remove("Hi_123"));
        assertTrue(myList.remove("Android"));

        assertEquals(myList.size(),5);
        assertEquals(myList.get(4),"Java_123");
    }

    @Test
    public void testMyListRemoveAll(){
        MyList<String> myList = new MyList<>();
        myList.add("Hello");
        myList.add("World");
        myList.add("Hi");
        myList.add("Java");
        myList.add("Android");
        myList.add("Hello_123");
        myList.add("World_123");
        myList.add("Hi_123");
        myList.add("Java_123");
        myList.add("Android_123");

        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("Android_123");
        stringList.add("Hi");
        stringList.add("Hi_123");
        stringList.add("Android");

        assertTrue(myList.removeAll(stringList));

        assertEquals(myList.size(),5);
        assertEquals(myList.get(4),"Java_123");
    }

    @Test
    public void testMyListIterator(){
        MyList<String> myList = new MyList<>();
        myList.add("Hello");
        myList.add("World");
        myList.add("Hi");
        myList.add("Java");
        myList.add("Android");

        String str = "";

        Iterator<String> iterator = myList.iterator();
        while(iterator.hasNext()){
            str += iterator.next();
        }

        assertEquals(str,"HelloWorldHiJavaAndroid");
    }
}
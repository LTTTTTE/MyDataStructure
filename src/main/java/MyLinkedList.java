import java.util.*;

public class MyLinkedList<Integer> implements List<Integer> {

    private int size;
    private Node head;
    private Node tail;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 && head == null;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean add(Integer data) {
        Node<Integer> newNode = new Node<>(data);

        if(head != null) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            head = tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, Integer data) {
        if(index == size){
            add(data);
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }

        Node target = find(index - 1);
        Node newNode = new Node<>(data);

        System.out.println(target.getData());

        newNode.next = target.next;
        target.next = newNode;
        newNode.next.prev = newNode;
        newNode.prev = target;

        size++;
    }

    public void addFirst(Integer data) {
        Node<Integer> newNode = new Node<>(data);

        if(head != null){
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            head = tail = newNode;
        }
        size++;
    }

    public void addLast(Integer data){
        add(data);
    }

    @Override
    public boolean remove(Object o) {

        if(head.getData().equals(o)){
            removeFirst();
            return true;
        }
        if(tail.getData().equals(o)){
            removeLast();
            return true;
        }

        Node target = head;
        while(target != null){
            if(target.getData().equals(o)) {
                break;
            }
            target = target.next;
        }

        Node prevTarget = target.prev;
        prevTarget.next = target.next;
        prevTarget.next.prev = prevTarget;
        size--;
        return true;
    }

    public Integer removeFirst(){
        if(head != null){
            Integer beforeData = (Integer) head.getData();
            head = head.next;
            size--;
            return beforeData;
        } else {
            throw new NoSuchElementException();
        }
    }

    public Integer removeLast(){
        if(head != null){
            Integer beforeData = (Integer) tail.getData();
            tail = tail.prev;
            tail.next = null;
            size--;
            return beforeData;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Integer remove(int index) {
        if(index == 0){
            return removeFirst();
        }
        if(index == size -1){
            return removeLast();
        }

        Node target = find(index);
        Node prevTarget = target.prev;
        Integer beforeData = (Integer) target.getData();

        prevTarget.next = target.next;
        prevTarget.next.prev = prevTarget;
        size--;

        return beforeData;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
        System.gc();
    }

    @Override
    public Integer get(int index) {
        return (Integer) find(index).getData();
    }

    public Node find(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node target = head;
        while(index > 0){
            target = target.next;
            index --;
        }
        return target;
    }

    @Override
    public Integer set(int index, Integer element) {
        find(index).setData(element);
        return element;
    }

    @Override
    public int indexOf(Object data) {
        int index = 0;

        for(Node target = head; target != null; target = target.next, index++){
            if(target.getData().equals(data))
                return index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object data) {
        int index = size - 1;

        for(Node target = tail; target != null; target = target.prev, index--){
            if(target.getData().equals(data))
                return index;
        }
        return -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        boolean flag = true;

        for(Object s : c){
           flag &= contains(s);
        }

        return flag;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        boolean flag = true;

        for(Integer s : c){
            flag &= add(s);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {

        int beforeSize = size;

        for(Integer s : c){
            add(index++, s);
        }
        return beforeSize + c.size() == size;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        boolean flag = true;

        for(Object s : c){
            flag &= remove(s);
        }

        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public String toString(){
        String str = "[";
        for(Node target = head; target != null ; target = target.next){
            str += target.getData();
            if(target.next != null){
                str += ", ";
            }
        }
        return str + "]";
    }
}

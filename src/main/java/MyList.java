import java.util.*;

public class MyList<String> implements List<String> {

    private String[] array;
    private int size;

    public MyList() {
        this.array = (String[]) new Object[1];
        this.size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
       return size == 0;
    }

    @Override
    public boolean add(String element) {
        if(size >= array.length){
            String[] bigger = (String[]) new Object[size*2];
            System.arraycopy(array,0,bigger,0,array.length); //deep copy
            array = bigger;
        }
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int index, String element) {
        //index
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        add(element);

        //sort
        for(int i = size -1; i > index ; i--){
            array[i] = array[i -1];
        }
        array[index] = element;

    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        boolean flag = true;

        for(String element : c){
            flag &= add(element);
        }

        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {

        int beforeSize = size;

        for(String element : c){
            add(index++, element);
        }

        return size == (beforeSize + c.size());
    }

    @Override
    public String get(int index) {
        //index
        if(index < 0 || index >size){
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object element :c){
            if(!contains(element)) return false;
        }
        return true;
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0 ; i < size; i++){
            if(equals(array[i],o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size -1; i >= 0; i--){
            if(equals(array[i],o)) return i;
        }
        return -1;
    }

    private boolean equals(Object target, Object element){
        if(target == null){
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    @Override
    public String remove(int index) {
        if(index == -1){
            throw new NoSuchElementException();
        }
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        for(int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        size--;
        return array[index];
    }

    @Override
    public boolean remove(Object o) {
        remove(indexOf(o));
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        boolean flag = true;

        for(Object s :c){
            flag &= remove(s);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public String set(int index, String element) {

        if(index < 0 || index >size){
            throw new IndexOutOfBoundsException();
        }
        return array[index] = element;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public String next() {
                return array[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public java.lang.String toString(){
        java.lang.String str = "[";
        for(int i=0; i<size; i++){
            str+=array[i];

            if(i!=size-1){
                str +=", ";
            }
        }
        return str+"]";
    }

}

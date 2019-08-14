public class Node<T> {
    private T data;
    public Node<T> prev;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

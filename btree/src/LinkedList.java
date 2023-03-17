public class LinkedList<T> {
    LLNode<T> head;
    LLNode<T> tail;

    public LinkedList() {
        head = null;
        tail = null;
    }
}

class LLNode<T> {
    T data;
    LLNode<T> next;

    LLNode(T data) {
        this.data = data;
        this.next = null;
    }
}
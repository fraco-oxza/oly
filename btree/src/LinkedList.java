public class LinkedList<T> {
    LLNode<T> head;
    LLNode<T> tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void push(T val) {
        LLNode<T> newNode = new LLNode<>(val);

        if (head == null) {
            head = newNode;
            tail = head;
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;

        tail = tail.next;
    }

    public T pop_back() {
        T val = tail.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        return val;
    }

    public T index(int pos) {
        int i = 0;
        LLNode<T> node = head;

        while (i < pos && node != null) {
            node = node.next;
            i++;
        }

        if (node == null) return null;
        return node.data;
    }

    public void print() {
        LLNode<T> node = head;

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

class LLNode<T> {
    T data;
    LLNode<T> prev;
    LLNode<T> next;

    LLNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
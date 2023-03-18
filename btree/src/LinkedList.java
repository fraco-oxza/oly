public class LinkedList<T> {
    LLNode<T> head;
    LLNode<T> tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void push(T val) {
        LLNode<T> newNode = new LLNode<>(val);

        if (head == null){
            head = newNode;
            tail = head;
            return;
        }

        LLNode<T> node = tail;

        while (node.next != null) {
            node = node.next;
        }

        node.next = newNode;
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
    LLNode<T> next;

    LLNode(T data) {
        this.data = data;
        this.next = null;
    }
}
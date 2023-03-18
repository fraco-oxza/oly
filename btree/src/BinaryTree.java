public class BinaryTree<T extends Comparable<T>> {
    BTNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public void push(T val) {
        if (root == null) {
            root = new BTNode<>(val);
            return;
        }
        BTNode<T> node = root;

        boolean inserted = false;
        while (!inserted) {
            if (val.compareTo(node.data) > 0) {
                // Push to the right
                if (node.right == null) {
                    node.right = new BTNode<>(val);
                    inserted = true;
                } else {
                    node = node.right;
                }
            } else {
                // Push to the left
                if (node.left == null) {
                    node.left = new BTNode<>(val);
                    inserted = true;
                } else {
                    node = node.left;
                }
            }

        }


    }

    public Boolean contains(T val) {
        BTNode<T> node = root;
        while (node != null) {
            System.out.println(node.data);
            if (node.data == val) {
                return true;
            }

            if (node.data.compareTo(val) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return false;
    }

    public void print() {
        BTNode.print(root);
        System.out.println();
    }
}

class BTNode<T> {
    T data;
    BTNode<T> left;
    BTNode<T> right;

    BTNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    static <T> void print(BTNode<T> node) {
        if (node == null) return;

        System.out.print(node.data + " ");
        print(node.left);
        print(node.right);
    }
}
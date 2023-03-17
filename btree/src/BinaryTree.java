public class BinaryTree {
    BTNode root;

    public BinaryTree() {
        root = null;
    }

    public void push(int val) {
        if (root == null) {
            root = new BTNode(val);
            return;
        }
        BTNode node = root;

        while (true) {
            if (val > node.data) {
                // Push to the right
                if (node.right == null) {
                    node.right = new BTNode(val);
                    break;
                } else {
                    node = node.right;
                }
            } else {
                // Push to the left
                if (node.left == null) {
                    node.left = new BTNode(val);
                    break;
                } else {
                    node = node.left;
                }
            }

        }
    }

    public void print() {
        BTNode.print(root);
        System.out.println();
    }
}

class BTNode {
    int data;
    BTNode left;
    BTNode right;

    BTNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    static void print(BTNode node) {
        if (node == null) return;

        print(node.left);
        print(node.right);
        System.out.print(node.data + " ");

    }
}
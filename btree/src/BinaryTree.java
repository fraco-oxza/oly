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
                    node.right.prev = node;
                    inserted = true;
                } else {
                    node = node.right;
                }
            } else {
                // Push to the left
                if (node.left == null) {
                    node.left = new BTNode<>(val);
                    node.left.prev = node;
                    inserted = true;
                } else {
                    node = node.left;
                }
            }

        }


    }

    public void delete(T val) {
        // Find the node
        BTNode<T> node = root;

        while (node != null && node.data != val) {
            if (node.data.compareTo(val) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        // Detect how to proceed
        // If it doesn't exist the node
        if (node == null) return;
        // Zero child case
        if (node.left == null && node.right == null) {
            // Root case
            if (node.prev == null) {
                root = null;
                return;
            }

            if (node.prev.data.compareTo(val) > 0) {
                node.prev.left = null;
            } else {
                node.prev.right = null;
            }
            node.prev = null;
            return;
        }
        // One child on the right side case
        if (node.right != null && node.left == null) {
            // Root case
            if (node.prev == null) {
                root = node.right;
                root.prev = null;
                return;
            }

            if (node.prev.data.compareTo(val) > 0) {
                node.right.prev = node.prev;
                node.prev.left = node.right;
            } else {
                node.right.prev = node.prev;
                node.prev.right = node.right;
            }
            return;
        }
        // One child on the left side case
        if (node.right == null) {
            // Root case
            if (node.prev == null) {
                root = node.left;
                root.prev = null;
                return;
            }

            if (node.prev.data.compareTo(val) > 0) {
                node.left.prev = node.prev;
                node.prev.left = node.left;
            } else {
                node.left.prev = node.prev;
                node.prev.right = node.left;
            }
            return;
        }

        // Two children case
        BTNode<T> replace_node = node.right;
        if (replace_node.left == null) {
            replace_node.prev.right = replace_node.right;

        } else {
            while (replace_node.left != null) replace_node = replace_node.left;


            replace_node.prev.left = replace_node.right;
        }

        if (replace_node.right != null) replace_node.right.prev = replace_node.prev;
        node.data = replace_node.data;
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

    public boolean isBalanced() {
        return BTNode.isBalanced(root);
    }

    public int maxDeep() {
        return BTNode.maxDeep(root);
    }

    public void print() {
        BTNode.print(root);
        System.out.println();
    }

    public int size() {
        return BTNode.size(root);
    }
}

class BTNode<T> {
    T data;
    BTNode<T> prev;
    BTNode<T> left, right;


    BTNode(T data) {
        this.data = data;
        prev = null;
        left = null;
        right = null;
    }

    static <T> void print(BTNode<T> node) {
        if (node == null) return;

        System.out.print(node.data + " ");
        print(node.left);
        print(node.right);
    }

    static <T> int size(BTNode<T> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return size(node.right) + size(node.left) + 1;

    }

    static <T> boolean isBalanced(BTNode<T> node) {
        return true;

    }

    static <T> int maxDeep(BTNode<T> node) {
        if (node == null) return 0;

        return Math.max(maxDeep(node.right), maxDeep(node.left)) + 1;
    }
}
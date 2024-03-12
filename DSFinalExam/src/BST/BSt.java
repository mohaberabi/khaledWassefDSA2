package BST;

public class BSt {


    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {

            data = d;
            left = null;
            right = null;
        }
    }

    private Node root;

    public BSt() {
        root = null;
    }

    public void postOrder() {
        postOrder(root);
    }


    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    public void preOrder() {
        preOrder(root);
    }


    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);

        preOrder(node.left);
        preOrder(node.right);
    }


    public void inOrder() {
        inOrder(root);
    }

    void insert(int x) {
        root = insert(root, x);
    }


    void insertIterative(int x) {
        Node added = new Node(x);
        if (root == null) {
            root = added;
            return;
        }
        Node curr = root;
        Node parent = null;

        while (curr != null) {
            parent = curr;
            if (curr.data > x) {
                curr = curr.left;
            } else if (curr.data < x) {
                curr = curr.right;
            } else {
                return;
            }
        }
        if (x > parent.data) {
            parent.right = added;
        } else {
            parent.left = added;
        }
    }


    boolean searchRecursive(Node node, int x) {
        if (node == null) {
            return false;
        }
        if (node.data == x) {
            return true;
        } else if (x > node.data) {
            return searchRecursive(node.right, x);
        } else {
            return searchRecursive(node.left, x);
        }
    }

    public Node insert(Node root, int x) {
        Node added = new Node(x);
        if (root == null) {
            return added;
        }
        if (x > root.data) {
            root.right = insert(root.right, x);

        } else if (x < root.data) {
            root.left = insert(root.left, x);
        }
        return root;
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public static void main(String[] args) {

        BSt bst = new BSt();
        bst.insertIterative(1);
        bst.insertIterative(2);
        bst.insertIterative(3);
        bst.insertIterative(4);
        bst.insertIterative(5);
        bst.insertIterative(90);

        bst.inOrder();

        boolean exist = bst.searchRecursive(bst.root, 90);
        System.out.println(exist);
    }


    boolean search(int x) {
        if (root == null) {
            return false;
        }
        Node curr = root;
        while (curr != null) {
            if (curr.data == x) {
                return true;
            } else if (curr.data > x) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return false;
    }
}

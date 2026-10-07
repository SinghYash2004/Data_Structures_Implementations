class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    BSTNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {

    BSTNode root;

    // Insert a node
    public void insert(int data) {
        root = insert(root, data);
    }

    private BSTNode insert(BSTNode root, int data) {
        if (root == null) {
            return new BSTNode(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Search an element
    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(BSTNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // Delete a node
    public void delete(int key) {
        root = delete(root, key);
    }

    private BSTNode delete(BSTNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        }

        else if (key > root.data) {
            root.right = delete(root.right, key);
        }

        else {

            // Case 1: Leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One Child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two Children
            BSTNode successor = findMinNode(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    // Find Minimum
    public int findMin() {

        if (root == null) {
            throw new RuntimeException("Tree is Empty");
        }

        return findMinNode(root).data;
    }

    private BSTNode findMinNode(BSTNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // Find Maximum
    public int findMax() {

        if (root == null) {
            throw new RuntimeException("Tree is Empty");
        }

        BSTNode current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    // Inorder Successor
    public Integer inorderSuccessor(int key) {

        BSTNode current = root;
        BSTNode successor = null;

        while (current != null) {

            if (key < current.data) {
                successor = current;
                current = current.left;
            }

            else if (key > current.data) {
                current = current.right;
            }

            else {

                if (current.right != null) {
                    return findMinNode(current.right).data;
                }

                break;
            }
        }

        return successor == null ? null : successor.data;
    }

    // Inorder Predecessor
    public Integer inorderPredecessor(int key) {

        BSTNode current = root;
        BSTNode predecessor = null;

        while (current != null) {

            if (key > current.data) {
                predecessor = current;
                current = current.right;
            }

            else if (key < current.data) {
                current = current.left;
            }

            else {

                if (current.left != null) {

                    BSTNode temp = current.left;

                    while (temp.right != null) {
                        temp = temp.right;
                    }

                    return temp.data;
                }

                break;
            }
        }

        return predecessor == null ? null : predecessor.data;
    }

    // Count Nodes
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(BSTNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Height of Tree
    public int height() {
        return height(root);
    }

    private int height(BSTNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Sum of Nodes
    public int sumNodes() {
        return sumNodes(root);
    }

    private int sumNodes(BSTNode root) {

        if (root == null) {
            return 0;
        }

        return root.data + sumNodes(root.left) + sumNodes(root.right);
    }

    // Inorder Traversal
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(BSTNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(BSTNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal
    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(BSTNode root) {

        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.print("Inorder: ");
        bst.inorder();

        System.out.print("Preorder: ");
        bst.preorder();

        System.out.print("Postorder: ");
        bst.postorder();

        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Min: " + bst.findMin());
        System.out.println("Max: " + bst.findMax());

        System.out.println("Nodes: " + bst.countNodes());
        System.out.println("Height: " + bst.height());
        System.out.println("Sum: " + bst.sumNodes());

        System.out.println("Successor of 50: " + bst.inorderSuccessor(50));
        System.out.println("Predecessor of 50: " + bst.inorderPredecessor(50));

        bst.delete(50);

        System.out.print("After Deletion: ");
        bst.inorder();
    }
}
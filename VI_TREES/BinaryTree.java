// 1. Preorder
// 2, Inorder 
// 3. Postorder
// 4. Count Node
// 5. Count Leaf Node
// 6. Sum of Nodes
// 7. Height
// 8. Search Element
// 9. Find Max

class BNode {
    int data;
    BNode left;
    BNode right;

    BNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {

    BNode root;

    void LevelOrder() {
        int h = Height(root);

        for (int i = 1; i <= h; i++)
            PrintLevel(root, i);
    }

    private void PrintLevel(BNode node, int level) {
        if (node == null)
            return;

        if (level == 1)
            System.out.print(node.data + " ");
        else {
            PrintLevel(node.left, level - 1);
            PrintLevel(node.right, level - 1);
        }
    }

    // Preorder Traversal
    public void Preorder() {
        Preorder(root);
    }

    private void Preorder(BNode node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        Preorder(node.left);
        Preorder(node.right);
    }

    // Inorder Traversal
    public void Inorder() {
        Inorder(root);
    }

    private void Inorder(BNode root) {
        if (root == null)
            return;

        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    // Postorder Traversal
    public void Postorder() {
        Postorder(root);
    }

    private void Postorder(BNode root) {
        if (root == null)
            return;

        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Count Total Nodes
    public int CountNodes() {
        return CountNodes(root);
    }

    private int CountNodes(BNode root) {
        if (root == null)
            return 0;

        return 1 + CountNodes(root.left) + CountNodes(root.right);
    }

    public int CountLeafNodes() {
        return CountLeafNodes(root);
    }

    private int CountLeafNodes(BNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return CountLeafNodes(root.left) + CountLeafNodes(root.right);
    }

    public int sumNodes() {
        return sumNodes(root);
    }

    private int sumNodes(BNode root) {
        if (root == null) {
            return 0;
        }

        return root.data + sumNodes(root.left) + sumNodes(root.right);
    }

    public int Height() {
        return Height(root);
    }

    private int Height(BNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);

        // return 1 + Math.max(Height(root.left), Height(root.right));
    }

    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(BNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        return search(root.left, key) || search(root.right, key);
    }

    public int findMax() {
        return findMax(root);
    }

    private int findMax(BNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.root = new BNode(10);
        tree.root.left = new BNode(20);
        tree.root.right = new BNode(30);
        tree.root.left.left = new BNode(40);
        tree.root.left.right = new BNode(50);

        System.out.print("Levelorder: ");
        tree.LevelOrder();
        System.out.println();

        System.out.print("Preorder: ");
        tree.Preorder();

        System.out.println();

        System.out.print("Inorder: ");
        tree.Inorder();

        System.out.println();

        System.out.print("Postorder: ");
        tree.Postorder();

        System.out.println();

        System.out.println("No of Nodes: " + tree.CountNodes());
        System.out.println("No of Leaf Nodes: " + tree.CountLeafNodes());
        System.out.println("Sum of Nodes: " + tree.sumNodes());
        System.out.println("Height of Tree: " + tree.Height());
        System.out.println("50 exist in Tree: " + tree.search(50));
        System.out.println("Max element: " + tree.findMax());
    }
}
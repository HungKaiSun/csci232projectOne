package binarytree;

/**
 *
 * @author Hung-Kai Sun
 */
class Node {

    int key;
    Node left, right;

    public Node(int item) {
        this.key = item;
        this.left = null;
        this.right = null;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getKey() {
        return this.key;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }
}

public class BinaryTree {

    // Root of Binary Tree 
    Node root;

    BinaryTree() {
        root = null;
    }

    public String printTree() {
        return "[" + this.recentPrintTree(root) + "]";
    }

    //print the tree
    private String recentPrintTree(Node roots) {
        if (roots == null) {
            return "";
        } else {
            return "[" + this.recentPrintTree(roots.getLeft()) + roots.getKey() + "[" + this.recentPrintTree(roots.getRight()) + "]";
        }
    }

    String temper;

    //Given a binary tree, and print its nodes according to the "bottom-up" postorder traversal.
    public String printPostorder(Node node) {

        if (node == null) {
            return "";
        }

        // first recur on left subtree 
        printPostorder(node.left);

        // then recur on right subtree 
        printPostorder(node.right);

        // now deal with the node 
        temper = (temper + node.key + " ");
        return temper;
    }

    // Given a binary tree, print its nodes in inorder
    public String printInorder(Node node) {
        if (node == null) {
            return "";
        }

        // first recur on left child 
        printInorder(node.left);

        // then print the data of node 
        temper = (temper + node.key + " ");

        // now recur on right child 
        printInorder(node.right);
        return temper;
    }

    // Given a binary tree, print its nodes in preorder
    public String printPreorder(Node node) {
        if (node == null) {
            return "";
        }

        // first print data of node
        temper = (temper + node.key + " ");

        // then recur on left sutree
        printPreorder(node.left);

        // now recur on right subtree
        printPreorder(node.right);
        return temper;
    }

    // Wrappers over above recursive functions 
    public String printPostorder() {
        temper = "";
        printPostorder(root);
        return temper;
    }

    public String printInorder() {
        temper = "";
        printInorder(root);
        return temper;
    }

    public String printPreorder() {
        temper = "";
        printPreorder(root);
        return temper;
    }

    //input the value
    public void insert(int value) {
        this.root = this.recentInt(root, value);
    }

    public Node recentInt(Node roots, int node) {
        if (roots == null) {
            return new Node(node);
        }
        if (roots.getKey() < node) {
            roots.setRight(this.recentInt(roots.getRight(), node));
            return roots;
        } else {
            roots.setLeft(this.recentInt(roots.getLeft(), node));
            return roots;
        }
    }

    public boolean search(int key) {
        return this.recentSearch(root, key);
    }

    //search node
    public boolean recentSearch(Node roots, int node) {
        if (roots == null) {
            return false;
        }
        if (roots.getKey() == node) {
            return true;
        } else if (roots.getKey() > node) {
            return this.recentSearch(roots.getLeft(), node);
        } else {
            return this.recentSearch(roots.getRight(), node);
        }
    }

    public void delete(int key) {
        this.root = recentDelete(root, key);
    }

    //delete node
    private Node recentDelete(Node roots, int node) {
        if (roots == null) {
            return null;
        }
        int condition;
        if (roots.getLeft() == null && roots.getRight() == null) {
            condition = 1;
        } else if (roots.getLeft() != null && roots.getRight() == null) {
            condition = 2;
        } else if (roots.getRight() != null && roots.getLeft() == null) {
            condition = 3;
        } else {
            condition = 4;
        }
        if (roots.getKey() == node) {
            switch (condition) {
                case 1:
                    roots = null;
                    break;
                case 2:
                    roots = roots.getLeft();
                    break;
                case 3:
                    roots = roots.getRight();
                    break;
                case 4:
                    String[] temp = temper.split(" ");
                    int[] successor = new int[temp.length];
                    int deleted = 0;
                    for (int i = 0; i < temp.length; i++) {
                        successor[i] = Integer.parseInt(temp[i]);
                    }
                    for (int i = 0; i < temp.length; i++) {
                        if (node == successor[i]) {
                            deleted = successor[i - 1];
                        }
                    }
                    this.recentDelete(roots, deleted);
                    roots.key = deleted;
            }
            return roots;
        } else if (roots.getKey() < node) {
            roots.setRight(this.recentDelete(roots.getRight(), node));
            return roots;
        } else {
            roots.setLeft(this.recentDelete(roots.getLeft(), node));
            return roots;
        }
    }
}

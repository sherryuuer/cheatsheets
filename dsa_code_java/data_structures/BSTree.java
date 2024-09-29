package dsa_code_java.data_structures;

import java.util.ArrayList;
import java.util.List;

public class BSTree {
    BSTreeNode root;

    public void insert(int key, int val) {
        BSTreeNode newNode = new BSTreeNode(key, val);
        if (root == null) {
            root = newNode;
            return;
        }

        BSTreeNode current = root;
        // 这整个过程是用key不断比较和迭代的过程
        // 最终找到正确的节点，然后将val赋予上去
        while (true) {
            if (key < current.key) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else if (key > current.key) {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            } else {
                current.val = val;
                return;
            }
        }
    }

    public int get(int key) {
        BSTreeNode current = root;

        while (current != null) {
            if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else {
                return current.val;
            }
        }

        return -1;
    }

    public int getMinVal() {
        BSTreeNode minNode = findMinNode(root);
        return (minNode != null) ? minNode.val : -1;
    }

    public BSTreeNode findMinNode(BSTreeNode node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getMaxVal() {
        BSTreeNode current = root;
        while (current != null && current.right != null) {
            current = current.right;
        }
        return (current != null) ? current.val : -1;
    }

    public void remove(int key) {
        root = removeHelper(key, root);
    }

    public BSTreeNode removeHelper(int key, BSTreeNode curr) {
        if (curr == null) {
            return null;
        }

        if (key < curr.left.key) {
            curr = removeHelper(key, curr.left);
        } else if (key > curr.right.key) {
            curr = removeHelper(key, curr.right);
        } else {
            if (curr.left == null) {
                return curr.right;
            } else if (curr.right == null) {
                return curr.left;
            } else {
                BSTreeNode minNode = findMinNode(curr.right);
                curr.key = minNode.key;
                curr.val = minNode.val;
                curr.right = removeHelper(minNode.key, curr.right);
            }
        }
        return curr;
    }

    public void inorderTraversal(BSTreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.key);
            inorderTraversal(root.right, result);
        }

    }

    public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
}

package 二叉树;

import java.util.*;
import java.io.*;

public class BinaryTree {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        Tree tree = new Tree(nums);
        tree.res.clear();
        tree.inOrder(tree.root);
        System.out.println(tree.res.toString());

    }
}

class Tree {
    Node root;
    int nums[];
    static ArrayList<Integer> res;

    public Tree(int[] nums) {
        this.nums = nums;
        this.root = build(0);
        this.res = new ArrayList<>();
    }

    Node build(int i) {
        if (i >= nums.length)
            return null;
        Node node = new Node(nums[i]);
        node.left = build(i * 2 + 1);
        node.right = build(i * 2 + 2);
        return node;
    }

    // 先序遍历
    void preOrder(Node node) {
        if (node == null)
            return;
        res.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 先序遍历快版，非递归
    void ipreOrder(Node node) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            res.add(node.val);
            if (node.right != null)
                stack.push(node.right);// 当右子树不为空时，将右子树压入栈中
            if (node.left != null)
                stack.push(node.left);// 当左子树不为空时，将左子树压入栈中
        }
    }

    // 中序遍历
    void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        res.add(node.val);
        inOrder(node.right);
    }

    // 中序遍历快版，非递归
    static void iinOrder(Node node) {
        Deque<Node> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
    }

    // 后序遍历
    void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        res.add(node.val);
    }

    // 后序遍历快版，非递归
    void ipostOrder(Node node) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            res.add(0, node.val);
            if (node.left != null)
                stack.push(node.left);// 当右子树不为空时，将右子树压入栈中
            if (node.right != null)
                stack.push(node.right);// 当左子树不为空时，将左子树压入栈中
        }
    }

}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

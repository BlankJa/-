package LinkedList自写版;

import java.util.LinkedList;

public class LinkedListttt {
    public static void main(String[] args) {

        Elist list = new Elist();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // for loop print list
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }

        list.reverse();
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }
    }

}

class Elist {

    Node head;
    Node tail;

    Elist() {
        this.head = new Node(0, null);
        this.tail = this.head;
    }

    void add(int val) {

        // new Node(val, null);
        // Node cur = head;

        // while(cur.next != (null)){
        // cur = cur.next;
        // }
        // cur.next = new Node(val, null);

        tail.next = new Node(val, null);
        tail = tail.next;
        head.val--;
    }

    int get(int index) {
        Node cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    void set(int index, int val) {
        Node cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        cur.val = val;
    }

    void remove(int index) {
        if (head.val == 0) {
            return;
        }
        Node per = head;
        for (int i = 0; i < index; i++) {
            per = per.next;
        }
        Node cur = per.next;
        per.next = cur.next;
        cur = null;
        head.val--;
    }

    void insert(int index, int val) {
        Node per = head;
        for (int i = 0; i < index; i++) {
            per = per.next;
        }
        per.next = new Node(val, per.next);
        head.val++;
    }

    void Switch(int index1, int index2) {
        Node per1 = head;
        for (int i = 0; i < index1; i++) {
            per1 = per1.next;
        }
        Node cur1 = per1.next;
        Node per2 = head;
        for (int i = 0; i < index2; i++) {
            per2 = per2.next;
        }
        Node cur2 = per2.next;
        per1.next = cur2;
        per2.next = cur1;
        Node temp = cur1.next;
        cur1.next = cur2.next;
        cur2.next = temp;
    }

    void reverse() {
        Node cur = head.next;
        Node per = null;
        Node temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = per;
            per = cur;
            cur = temp;
        }
        head.next = per;
    }

}

class Node {

    int val;
    Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
package Deque自写版;

import java.util.*;

public class Dequeee {
    public static void main(String[] args) {

        Queue<Integer> q = new ArrayDeque<>();

    }
}

class ADequeue {// 数组写法

    int[] arr;
    int head, tail;

    ADequeue() {
        this.arr = new int[1000];// 设置初使大小
        head = 0;
        tail = 0;
    }

    void offerFirst(int val) {
        head = (head - 1 + arr.length) % arr.length;
        arr[head] = val;
    }

    void offerLast(int val) {
        arr[tail] = val;
        tail = (tail + 1) % arr.length;
    }

    int peekFirst() {
        return arr[head];
    }

    int peekLast() {
        return arr[(tail - 1 + arr.length) % arr.length];
    }

    int pollFirst() {
        int val = arr[head];
        head = (head + 1) % arr.length;
        return val;
    }

    int pollLast() {
        tail = (tail - 1 + arr.length) % arr.length;
        return arr[tail];
    }

    int size() {
        return (tail - head + arr.length) % arr.length;
    }

    boolean isEmpty() {
        return head == tail;
    }

    void print() {
        for (int i = head; i != tail; i = (i + 1) % arr.length) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class MDequeue {// LinkedList写法

    LinkedList<Integer> list;

    public MDequeue() {
        list = new LinkedList<>();
    }

    public void offerFirst(int val) {
        list.addFirst(val);
    }

    public void offerLast(int val) {
        list.addLast(val);
    }

    public int pollFirst() {
        return list.removeFirst();
    }

    public int pollLast() {
        return list.removeLast();
    }

    public int peekFirst() {
        return list.getFirst();
    }

    public int peekLast() {
        return list.getLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
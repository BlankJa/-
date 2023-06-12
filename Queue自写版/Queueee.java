package Queue自写版;

import java.util.*;

public class Queueee {
    static MQueue queue = new MQueue();

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<String>();

    }
}

class MQueue {

    LinkedList<Integer> list;

    public MQueue() {
        list = new LinkedList<>();
    }

    public void offer(int val) {
        list.add(val);
    }

    public int poll() {
        return list.removeFirst();
    }

    public int peek() {
        return list.getFirst();
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    // LinkedList 附加功能
    public void print() {
        System.out.println(list);
    }

    public void printReverse() {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public int get(int index) {
        return list.get(index);
    }

    public void set(int index, int val) {
        list.set(index, val);
    }

    public void add(int index, int val) {
        list.add(index, val);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public int indexOf(int val) {
        return list.indexOf(val);
    }

    public int lastIndexOf(int val) {
        return list.lastIndexOf(val);
    }

    public int removeFirst() {
        return list.removeFirst();
    }

    public int removeLast() {
        return list.removeLast();
    }

    public void addFirst(int val) {
        list.addFirst(val);
    }

    public void addLast(int val) {
        list.addLast(val);
    }

    public int getFirst() {
        return list.getFirst();
    }

    public int getLast() {
        return list.getLast();
    }
}

class AQueue {// 数组写法

    int[] arr;
    int head, tail;

    AQueue() {
        this.arr = new int[1000];// 设置初使大小
        head = 0;
        tail = 0;
    }

    void add(int val) {
        arr[tail++] = val;
    }

    int peek() {
        return arr[head];
    }

    int poll() {
        return arr[head++];
    }

    int size() {
        return tail - head;
    }

    boolean isEmpty() {
        return head == tail;
    }
}
package 比较器模板;

import java.util.*;

public class ComparatorTemplate {
    // Computer Purchase
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        Computer[] arr = new Computer[num];
        for (int i = 0; i < num; i++) {
            String name = input.next();
            int R = input.nextInt();
            int S = input.nextInt();
            int D = input.nextInt();
            arr[i] = new Computer(name, R, S, D);
        }
        Cmp cmp = new Cmp();
        Arrays.sort(arr, cmp);
        if (num == 1) {
            System.out.println(arr[0].name);
        } else if (num > 1) {
            System.out.println(arr[0].name);
            System.out.println(arr[1].name);
        }

    }
}

class Computer {
    public String name;
    public int score;

    Computer(String name, int r, int s, int d) {
        this.name = name;
        this.score = 2 * r + 3 * s + d;
    }
}

class Cmp implements Comparator<Computer> {
    @Override
    public int compare(Computer a, Computer b) {
        if (a.score < b.score) {
            return 1;
        } else if (a.score > b.score) {
            return -1;
        } else {
            return a.name.compareTo(b.name);
        }
    }
}
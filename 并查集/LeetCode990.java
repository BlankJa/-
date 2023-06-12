package 并查集;

import java.util.*;
import java.io.*;

public class LeetCode990 {
    public static void main(String[] args) {
        Input input = new Input();
        String[] equations = new String[26];

    }

}

class Input {
    BufferedReader buff;
    StringTokenizer token;

    Input() {
        buff = new BufferedReader(new InputStreamReader(System.in));
        token = new StringTokenizer("");
    }

    String next() {
        while (!token.hasMoreTokens()) {
            try {
                token = new StringTokenizer(buff.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return token.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}
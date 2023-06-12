package 输入模板;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Template {
    public static void main(String[] args) {
        Input input = new Input(System.in);
    }
}

class Input {
    BufferedReader buff;
    StringTokenizer tokenizer;

    public Input(InputStream in) {
        buff = new BufferedReader(new InputStreamReader(in), 65535);
        tokenizer = new StringTokenizer("");

    }

    public String next() {
        while (!tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(buff.readLine());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public String nextLine() {
        try {
            return buff.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public char nextChar() {
        try {
            return (char) buff.read();
        } catch (IOException e) {
        }
        return ' ';
    }
}

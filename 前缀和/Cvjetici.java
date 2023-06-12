import java.util.*;
import java.io.*;
public class Cvjetici {
    public static void main(String[] args){
        Input input = new Input(System.in);
        int n = input.nextInt();
        FenwickTree arr  = new FenwickTree(100001);
        for(int i = 0; i < n; i++){
            int l = input.nextInt();
            int r = input.nextInt();
            int left = arr.query(l);
            int right = arr.query(r);
            System.out.println(right + left);
            arr.update(l,-left);
            arr.update(l+1,left);
            arr.update(r,-right);
            arr.update(r+1,right);

            arr.update(l+1,1);
            arr.update(r,-1);
        }
    }
}


class FenwickTree{
    int[] tree;
    public FenwickTree(int n){
        tree = new int[n];
    }
    public void update(int i, int delta){
        while(i < tree.length){
            tree[i] += delta;
            i += i & -i;
        }
    }
    public int query(int i){
        int sum = 0;
        while(i > 0){
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }

}



class Input{
    BufferedReader buff;
    StringTokenizer tokenizer;
    public Input(InputStream in) {
        buff = new BufferedReader(new InputStreamReader(in), 65536);
        tokenizer = new StringTokenizer("");
    }
    private String next() {
        while (!tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(buff.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
}
import java.util.*;
import java.io.*;
import java.time.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int n, bit[], a[];
	public static void main(String[] args) throws IOException {
		n = readInt(); a = new int[n+1]; bit = new int[n+1];
		for(int i=1; i<=n; i++) a[i] = readInt();
		long ans = 0;
		for(int i=1, j=1; i<=n; i=j) {
			for(j=i+1; j<=n && a[j-1] > a[j]; j++);
			ans++;
			for(int l=i, r=j-1; l<r; l++, r--) {
				int tmp = a[l]; a[l] = a[r]; a[r] = tmp;
			}
		}
		for(int i=n; i>=1; i--) {
			ans += query(a[i]);  update(a[i], 1);
		}
		System.out.println(ans);
	}
	static long query(int pos) {
		long ret = 0;
		for(int i=pos; i>0; i-=i&-i) ret += bit[i];
		return ret;
	}
	static void update(int pos, int val) {
		for(int i=pos; i<bit.length; i+=i&-i) bit[i] += val;
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
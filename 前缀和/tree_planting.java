import java.util.*;
import java.io.*;
public class homework {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = (int)1e9 +7;
	public static void main(String[] args) throws IOException{
		int n = readInt(); long bit[][] = new long[2005][2005]; long ans = 0;
		for(int t=1; t<=n; t++) {
			int op = readInt(), r = readInt(), c = readInt(), x = readInt();
			if(op == 1) update(bit[r+c], r, x);
			else ans = (ans + query(bit[r+c], r) - query(bit[r+c], r-x-1) + mod) % mod;
		}
		System.out.println(ans);
	}
	static void update(long bit[], int pos, int val) {
		for(int i=pos; i<bit.length; i+=i&-i)
			bit[i] += val;
	}
	static long query(long bit[], int pos) {
		long sum = 0;
		for(int i=pos; i>0; i-=i&-i)
			sum = (sum + bit[i])%mod;
		return sum;
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
package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumOfGCD9613 {
	static int arr[], size;
	
	static int solve() {
		int sum = 0;
		for(int i = 0; i<size-1; i++) {
			for(int j = i+1; j<size; j++) {
				sum += gcd(arr[i], arr[j]);
			}
		}
		return sum;
	}
	
	static int gcd(int a, int b) {
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		return (max % min == 0)? min : gcd(min, max%min);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			arr = new int[size];
			for(int i = 0; i<size; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			bw.write(solve() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}

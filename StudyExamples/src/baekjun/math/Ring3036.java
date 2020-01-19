package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ring3036 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<arr.length; i++) {
			int gcd = (arr[0] >= arr[i])? gcd(arr[0], arr[i]) : gcd(arr[i], arr[0]);
			bw.write(String.format("%d/%d\n", arr[0]/gcd, arr[i]/gcd));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int gcd(int a, int b) {
		return (a%b == 0)? b : gcd(b, a%b);
	}
}

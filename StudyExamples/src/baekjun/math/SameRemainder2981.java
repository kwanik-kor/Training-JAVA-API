package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SameRemainder2981 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cha[] = new int[N-1];
		for(int i = 0; i<N-1; i++) {
			cha[i] = Math.abs(arr[i] - arr[i+1]);
		}
		for(int i = 0; i<cha.length-1; i++) {
			cha[i+1] = (cha[i]>=cha[i+1])? gcd(cha[i], cha[i+1]) : gcd(cha[i+1], cha[i]);
		}
		for(int i = 2; i<=cha[cha.length-1]; i++) {
			if(cha[cha.length-1]%i == 0)
				bw.write(i + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int gcd(int a, int b) {
		return (a%b == 0)? b : gcd(b, a%b);
	}
}

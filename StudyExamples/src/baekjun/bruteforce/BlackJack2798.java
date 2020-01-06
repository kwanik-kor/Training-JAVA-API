package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJack2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int N = Integer.parseInt(s1.split(" ")[0]);
		int M = Integer.parseInt(s1.split(" ")[1]);
		int[] arr = new int[N];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(s2.split(" ")[i]);
		}
		int max = 0;
		int sum = 0;
		for(int i = 0; i<arr.length; i++) {
			for(int j = i + 1; j<arr.length; j++) {
				for(int k = j + 1; k<arr.length; k++) {
					sum = arr[i] + arr[j] + arr[k];
					if(max < sum && sum <= M) 
						max = sum;
				}
			}
		}
		System.out.println(max);
	}

}

package baekjun.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Zero10773 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		int arr[] = new int[100000];
		int sum = 0;
		int last = 0;
		for(int i = 0; i<K; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n != 0) {
				arr[last] = n;
				sum += arr[last];
				last++;
			}else {
				last--;
				sum -= arr[last];
				arr[last] = 0;
			}
		}
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		br.close();
	}
}

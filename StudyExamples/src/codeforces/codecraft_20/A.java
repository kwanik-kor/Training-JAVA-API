package codeforces.codecraft_20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int arr[] = new int[n];
			
			st = new StringTokenizer(br.readLine());
			int total = 0;
			for(int i = 0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				total += arr[i];
			}
			if(n == 1) bw.write(arr[0] + "\n");
			else {
				if(total <= m) bw.write(total + "\n");
				else bw.write(m + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

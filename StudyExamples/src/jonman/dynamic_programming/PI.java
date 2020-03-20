package jonman.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PI {
	static int arr[] = new int[10001];
	static int cache[] = new int[10002];
	static int len;
	static int min;
	static int INF = 987654321;
	
	static int classify(int start, int end) {
		boolean type1 = true, type2 = true, type3 = true, type4 = true;
		
		for(int i = start; i<end-1; i++) {
			if(type1 && arr[i] != arr[i+1]) 
				type1 = false;
			if(type2 && arr[i+1] - arr[i] != 1)
				type2 = false;
			if(type3 && (i-start % 2 == 0)?arr[i] != arr[start] : arr[i] != arr[start+1])
				type3 = false;
			if(type4 && arr[i+1] - arr[i] != arr[start+1] - arr[start])
				type4 = false;
		}
		if(type1) return 1;
		else if(type2) return 2;
		else if(type3) return 4;
		else if(type4) return 5;
		return 10;
	}
	
	static int solve(int idx) {
		if(idx == len) return 0;
		if(cache[idx] != -1) return cache[idx];
		min = INF;
		for(int i = 3; i<=5; i++) {
			if(idx + i <= len)
				min = Math.min(min, solve(idx + i) + classify(idx, idx + i));
		}
		return min;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			String str = br.readLine();
			len = str.length();
			min = 987654321;
			Arrays.fill(cache, -1);
			for(int i = 0; i<len; i++) 
				arr[i] = str.charAt(i) - '0';
			bw.write(solve(0) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

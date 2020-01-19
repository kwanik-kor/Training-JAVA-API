package baekjun.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LostBracket1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String arr[] = br.readLine().split("\\-");
		int result = 0;
		for(int i = 0; i<arr.length; i++) {
			if(i == 0)
				result += calc(arr[i]);
			else
				result -= calc(arr[i]);
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int calc(String s) {
		String arr[] = s.split("\\+");
		int sum = 0;
		for(int i = 0; i<arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		return sum;
	}
}

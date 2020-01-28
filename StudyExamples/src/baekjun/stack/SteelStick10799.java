package baekjun.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SteelStick10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char arr[] = br.readLine().toCharArray();
		int cnt = 0;
		int sum = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == '(')
				cnt++;
			else if(arr[i] == ')' && arr[i-1] == '(') {
				cnt--;
				sum += cnt;
			}else {
				cnt--;
				sum++;
			}
				
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

package baekjun.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Thirty10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int arr[] = new int[s.length()];
		int sum = 0;
		boolean zeroChk = false;
		for(int i = 0; i<arr.length; i++) {
			arr[i] = s.charAt(i) - '0';
			sum += arr[i];
			if(arr[i] == 0) zeroChk = true;
		}
		if(zeroChk && sum % 3 == 0) {
			Arrays.sort(arr);
			for(int i = arr.length-1; i>=0; i--)
				bw.write(arr[i]+"");
		}else {
			bw.write("-1");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

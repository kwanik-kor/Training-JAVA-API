package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SqrtLogSin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int arr[] = new int[1000000];
		arr[0] = 1;
		for(int i = 1; i<1000000; i++) {
			arr[i] = arr[(int)(i - Math.sqrt(i))];
			arr[i] = (arr[i] + arr[(int)Math.log(i)]) % 1000000;
			arr[i] = (arr[i] + arr[(int)(i*Math.sin(i)*Math.sin(i))]) % 1000000;
		}
		int n;
		while((n = Integer.parseInt(br.readLine())) != -1) {
			bw.write(arr[n] % 1000000 + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}

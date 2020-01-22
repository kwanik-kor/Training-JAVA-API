package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SnowWhite2309 {
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		arr = new int[9];
		int sum = 0;
		boolean chk = false;
		for(int i = 0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		for(int i = 0; i<9; i++) {
			if(chk) break;
			for(int j = 0; j<9; j++) {
				if(i != j && sum - arr[i] - arr[j] == 100) {
					arr[i] = arr[j] = 0;
					chk = true;
					break;
				}
			}
		}
		Arrays.sort(arr);
		for(int i = 2; i<9; i++)
			bw.write(arr[i] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}

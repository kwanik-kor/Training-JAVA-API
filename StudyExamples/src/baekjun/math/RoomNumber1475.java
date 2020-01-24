package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RoomNumber1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int arr[] = new int[10];
		String s = br.readLine();
		int max = 0;
		for(int i = 0; i<s.length(); i++) {
			arr[Integer.parseInt(s.charAt(i)+"")]++;
		}
		int k = arr[6] + arr[9];
		arr[6] = arr[9] = (k%2 == 0)? k/2 : k/2 + 1;
		for(int i = 0; i<10; i++) {
			if(arr[i] > max) max = arr[i];
		}
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

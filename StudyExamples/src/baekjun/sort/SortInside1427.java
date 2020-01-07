package baekjun.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SortInside1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = br.readLine().split("");
		for(int i = 1; i<arr.length; i++) {
			int flag = 0;
			for(int j = 0; j<arr.length - i; j++) {
				if(arr[j].compareTo(arr[j+1])<0) {
					String temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = 1;
				}
			}
			if(flag == 0)
				break;
		}
		for(int i = 0; i<arr.length; i++)
			bw.write(arr[i]);
		bw.flush();
		bw.close();
		br.close();
	}

}

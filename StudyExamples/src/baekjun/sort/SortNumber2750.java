package baekjun.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SortNumber2750 {
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		sortByBubble();
		for(int i = 0; i<N; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void sortByBubble() {
		for(int i = 1; i<arr.length; i++) {
			int flag = 0;
			for(int j = 0; j<arr.length - i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = 1;
				}
			}
			if(flag == 0)
				break;
		}
	}

}

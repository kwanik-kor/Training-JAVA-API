package baekjun.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WoodFreak2947 {
	static int arr[] = new int[5];
	static StringBuilder sb = new StringBuilder("");
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<5; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		while(true) {
			int cnt = 0;
			for(int i = 0; i<4; i++) {
				if(arr[i] > arr[i+1]) {
					int tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					print();
					cnt++;
				}
			}
			if(cnt == 0) break;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void print() {
		for(int i = 0; i<5; i++)
			sb.append(arr[i] + " ");
		sb.append("\n");
	}

}

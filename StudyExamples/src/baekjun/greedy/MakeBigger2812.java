package baekjun.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MakeBigger2812 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char arr[] = br.readLine().toCharArray();
		int flag = 1;
		for(int i = 1; i<N; i++) {
			while(K > 0 && flag > 0 && arr[i-1] < arr[i]) {
				arr[flag - 1] = arr[flag];
				arr[flag] = 0;
				K--;
				flag--;
			}
			flag++;
		}
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}

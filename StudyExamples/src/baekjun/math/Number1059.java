package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Number1059 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int L = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[L];
		for(int i = 0; i<L; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int a = 0;
		int b = 0;
		for(int i = 0; i<L-1; i++) {
			if(arr[i] < N && arr[i+1] > N) {
				a = arr[i];
				b = arr[i+1];
				break;
			}
		}
		int result = 0;
		if(a != 0 && b != 0) {
			result = (N-b-1)*(a-N) + (a-N-1);
		}
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
			
	}

}

package baekjun.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class InsertOperator14888 {
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int N, arr[], operator[] = new int[4];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		operation(1, arr[0]);
		
		bw.write(max + "\n" + min);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void operation(int cnt, int sum) {
		if(cnt == N) {
			if(sum >= max)
				max = sum;
			if(sum <= min)
				min = sum;
			return;
		}
		
		for(int i = 0; i<4; i++) {
			if(operator[i] != 0) {
				operator[i]--;
				switch(i) {
				case 0:
					operation(cnt+1, sum + arr[cnt]);
					break;
				case 1:
					operation(cnt+1, sum - arr[cnt]);
					break;
				case 2:
					operation(cnt+1, sum * arr[cnt]);
					break;
				case 3:
					operation(cnt+1, sum / arr[cnt]);
					break;
				}
				operator[i]++;
			}
		}
	}
}

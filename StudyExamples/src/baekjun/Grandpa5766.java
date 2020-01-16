package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Grandpa5766 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		StringTokenizer st;
		while(!(s = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int arr[] = new int[10001];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<M; j++) {
					int n = Integer.parseInt(st.nextToken());
					arr[n]++;
				}
			}
			int max = arr[0];
			int secondMax = max;
			for(int i = 0; i<arr.length; i++) {
				if(arr[i] > max) {
					secondMax = max;
					max = arr[i];
				}else if(arr[i] > secondMax && arr[i] < max || max == secondMax)
					secondMax = arr[i];
			}
			for(int i = 0; i<arr.length; i++) {
				if(arr[i] == secondMax)
					bw.write(i + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

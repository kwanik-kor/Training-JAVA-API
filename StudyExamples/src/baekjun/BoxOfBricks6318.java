package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BoxOfBricks6318 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, cnt = 1;
		while((n=Integer.parseInt(br.readLine()))!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[n];
			int sum = 0;
			for(int i = 0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			sum /= n;
			int result = 0;
			for(int i = 0; i<n; i++) {
				if(arr[i] < sum)
					result += sum - arr[i];
			}
			bw.write(String.format("Set #%d\nThe minimum number of moves is %d.\n", cnt, result));
			cnt++;
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

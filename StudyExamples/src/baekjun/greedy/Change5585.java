package baekjun.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Change5585 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = 1000 - Integer.parseInt(br.readLine());
		int arr[] = {500, 100, 50, 10, 5, 1};
		int cnt = 0;
		for(int i = 0; i<6; i++) {
			if(N>=arr[i]) {
				cnt++;
				N -= arr[i];
				i--;
				if(N == 0) break;
			}
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}

}

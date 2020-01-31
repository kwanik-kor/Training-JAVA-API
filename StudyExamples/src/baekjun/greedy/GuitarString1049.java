package baekjun.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GuitarString1049 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int minSet = 1001;
		int minEach = 1001;
		int result = 0;
		for(int m = 0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			minSet = Math.min(minSet, Integer.parseInt(st.nextToken()));
			minEach = Math.min(minEach, Integer.parseInt(st.nextToken()));
		}
		if(minEach*6 > minSet) result = minSet * (N/6);
		else result = minEach * (N/6) * 6;
		N %= 6;
		if(minSet > minEach*N) result += minEach * N;
		else result += minSet;
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

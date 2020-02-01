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
		int N = Integer.parseInt(st.nextToken());//N자리수
		int K = Integer.parseInt(st.nextToken());//K개 지워서 최대 수 만들기
		char carr[] = br.readLine().toCharArray();
		char result[] = new char[N];
		int idx = 0;
		for(int i = 0; i<N; i++) {
			if(idx == N - K) break;
			while(idx > 0 && K > 0 && result[idx - 1] < carr[i]) {
				idx--;
				K--;
			}
			result[idx++] = carr[i];
		}
		for(int i = 0; i<result.length; i++)
			bw.write(result[i]);
		bw.flush();
		bw.close();
		br.close();
	}

}

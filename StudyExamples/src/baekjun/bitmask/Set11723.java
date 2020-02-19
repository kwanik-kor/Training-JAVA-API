package baekjun.bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Set11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int M = Integer.parseInt(br.readLine());
		int bitSet = 0;
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int N;
			switch(st.nextToken()) {
			case "add":
				N = Integer.parseInt(st.nextToken());
				bitSet = bitSet | (1 << N);
				break;
			case "remove": 
				N = Integer.parseInt(st.nextToken());
				bitSet = bitSet & ~(1 << N);
				break;
			case "check": 
				N = Integer.parseInt(st.nextToken());
				int result = bitSet & (1 << N);
				if(result > 0) bw.write("1\n");
				else bw.write("0\n");
				break;
			case "toggle": 
				N = Integer.parseInt(st.nextToken());
				bitSet = bitSet ^ (1 << N);
				break;
			case "all": 
				bitSet = (1 << 21) - 1;
				break;
			default: bitSet = 0;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

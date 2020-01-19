package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FashionKing9375 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int a = 0; a < T; a++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				String cloth = st.nextToken();
				String type = st.nextToken();
				if(map.get(type) != null)
					map.put(type, map.get(type) + 1);
				else
					map.put(type, 1);
			}
			int total = 1;
			for(String key : map.keySet()) {
				total *= (map.get(key) + 1);
			}
			bw.write(total - 1 + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

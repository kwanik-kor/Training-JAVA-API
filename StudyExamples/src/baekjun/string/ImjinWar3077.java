package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ImjinWar3077 {
	static HashMap<String, Integer> hm = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String arr[] = new String[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			String name = st.nextToken();
			hm.put(name, i);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			arr[i] = st.nextToken();
		int ans = 0;
		for(int i = 0; i<N-1; i++) {
			for(int j = i+1; j<N; j++) {
				if(hm.get(arr[j]) - hm.get(arr[i]) > 0)
					ans++;
			}
		}
		bw.write(String.format("%d/%d", ans, (N*(N-1))/2));
		bw.flush();
		bw.close();
		br.close();
	}

}

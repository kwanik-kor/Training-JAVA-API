package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Overtake2002 {
	static HashMap<String, Boolean> overtake = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] input = new String[N];
		String[] output = new String[N];
		for(int i = 0; i<N; i++) {
			String name = br.readLine();
			overtake.put(name, false);
			input[i] = name;
		}
		for(int i = 0; i<N; i++)
			output[i] = br.readLine();
		int cnt = 0;
		int out_idx = 0;
		for(int i = 0; i<N; i++) {
			if(out_idx >= N) break;
			String out = output[out_idx];
			//input 배열의 차가 이미 추월한 차량으로 판정됐을 때, 혹은 input과 같은 순번으로 빠져나올때
			if(overtake.get(input[i])) continue;
			if(input[i].equals(out)) {
				out_idx++;
				continue;
			}
			else {
				cnt++;
				overtake.replace(out, true);
				out_idx++;
				i--;
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

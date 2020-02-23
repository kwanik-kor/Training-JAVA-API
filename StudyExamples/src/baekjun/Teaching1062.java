package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Teaching1062 {
	static int N, K;
	static ArrayList<String> list = new ArrayList<>();
	static ArrayList<Integer> words = new ArrayList<>();
	static int ans = 0;

	static void backTracking(boolean chk[], int cnt) {
		if(cnt == K - 5) {
			ans = Math.max(ans, checkWord(chk));
			return;
		}
		for(int i = 0; i<words.size(); i++) {
			if(chk[i]) continue;
			chk[i] = true;
			backTracking(chk, cnt + 1);
			chk[i] = false;
		}
	}
	
	static int checkWord(boolean chk[]) {
		int cnt = 0;
		for(String s : list) {
			boolean flag = true;
			for(int i = 0; i<s.length(); i++) {
				int c = s.charAt(i) - 97;
				if(!chk[words.indexOf(c)]) {
					flag = false;
					break;
				}
			}
			if(flag) cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine().replaceAll("[antic]", "");
			list.add(s);
			for(int j = 0; j<s.length(); j++) {
				boolean flag = false;
				for(Integer in : words) {
					if(in == s.charAt(j) - 97) 
						flag = true;
				}
				if(!flag) words.add(s.charAt(j) - 97);
			}
		}
		
		if(K < 5) {
			bw.write("0");
		}else if(K == 26 || K-5 >= words.size()){
			bw.write(N + "");
		}else {
			boolean chk[] = new boolean[words.size()];
			backTracking(chk, 0);
			bw.write(ans + "");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}

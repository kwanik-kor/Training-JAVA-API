package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NumberBaseball2503 {
	static int cnt = 0;
	static String str[];
	static int strike[];
	static int ball[];
	static int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	static boolean isPossible(String baseball) {
		String chk[] = baseball.split("");
		for(int i = 0; i<str.length; i++) {
			String chk2[] = str[i].split("");
			int s = 0;
			int b = 0;
			for(int j = 0; j<3; j++) {
				if(chk[j].equals(chk2[j])) s++;
			}
			
			for(int j = 0; j<3; j++) {
				for(int k = 0; k<3; k++) {
					if(j == k) continue;
					if(chk[j].equals(chk2[k])) b++;
				}
			}
			
			if(s != strike[i] || b != ball[i]) return false;
		}
		return true;
	}
	
	static void permutation(int[] set, int size, int N, int K) {
		if(size == K) {
			String baseball = "";
			for(int i = 0; i<size; i++) 
				baseball += Integer.toString(numbers[set[i]]);
			if(isPossible(baseball)) cnt++;
			return;
		}
		
		for(int i = size; i<N; i++) {
			swap(set, i, size);
			permutation(set, size+1, N, K);
			swap(set, i, size);
		}
	}
	
	static void swap(int[] set, int i, int index) {
		int tmp = set[i];
		set[i] = set[index];
		set[index] = tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		str = new String[N];
		strike = new int[N];
		ball = new int[N];
		for(int n = 0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			str[n] = st.nextToken();
			strike[n] = Integer.parseInt(st.nextToken());
			ball[n] = Integer.parseInt(st.nextToken());
		}
		int set[] = new int[9];
		for(int i = 0; i<9; i++)
			set[i] = i;
		permutation(set, 0, 9, 3);
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

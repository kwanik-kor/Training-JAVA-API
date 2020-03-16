package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Teaching1062 {
	static int N, K, max = 0;
	static int alphabet[];
	static String[] words;
	
	public static void checkMaxRead(ArrayList<Integer> list) {
		int cnt = 0;
		boolean canRead[] = new boolean[26];
		for(Integer i : list) 
			canRead[i] = true;
		
		for(int i = 0; i<N; i++) {
			char carr[] = words[i].toCharArray();
			boolean flag = true;
			for(int j = 0; j<carr.length; j++) {
				if(!canRead[carr[j] - 'a']) {
					flag = false;
					break;
				}
			}
			if(flag) cnt++;
		}
		max = Math.max(max, cnt);
	}
	
	public static void selectAlphabet(int size, ArrayList<Integer> list) {
		if(size == K-5) {
			//check how many words that students can read
			checkMaxRead(list);
			return;
		}
		int small = list.isEmpty()? 1 : list.get(list.size() - 1) + 1;
		for(int next = small; next<26; next++) {
			if(next == 0 || next == 2 || next == 8 || next == 13 || next == 19)
				continue;
			list.add(next);
			selectAlphabet(size + 1, list);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		for(int i = 0; i<N; i++)
			words[i] = br.readLine().replaceAll("[acint]", "");
		if(K < 5) bw.write("0");
		else {
			selectAlphabet(0, new ArrayList<Integer>());
			bw.write(max + "");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}

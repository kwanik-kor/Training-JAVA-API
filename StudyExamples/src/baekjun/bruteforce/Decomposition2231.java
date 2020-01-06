package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decomposition2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//분해합 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean flag = false;
		for(int i = 1; i<N; i++) {
			String s = String.valueOf(i);
			int sum = i;
			for(int j = 0; j<s.length(); j++) {
				sum += Integer.parseInt(s.substring(j, j+1));
			}
			if(sum == N) {
				System.out.println(i);
				flag = true;
				break;
			}
		}
		if(!flag)
			System.out.println(0);
	}

}

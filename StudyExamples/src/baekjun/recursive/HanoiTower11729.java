package baekjun.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HanoiTower11729 {
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		for(int i = 0; i<N; i++) {
			cnt *= 2;
		}
		bw.write(String.valueOf(cnt - 1) + "\n"); //hanoi 타워의 규칙은 2^n - 1 개다.
		hanoi(N, 1, 2, 3);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void hanoi(int n, int a, int b, int c) throws IOException {
		if(n == 1) {
			bw.write(a + " " + c + "\n");
			return;
		}
		hanoi(n-1, a, c, b);
		bw.write(a + " " + c + "\n");
		hanoi(n-1, b, a, c);
	}
}

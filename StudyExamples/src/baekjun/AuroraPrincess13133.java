package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AuroraPrincess13133 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean chk[] = new boolean[N+1];
		int parent[][] = new int[N+1][2];
		for(int i = 1; i<=N; i++) {
			chk[i] = true;
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			parent[i][0] = m;
			parent[i][1] = f;
		}
		int M = Integer.parseInt(br.readLine());
		if(M > 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++)
				chk[Integer.parseInt(st.nextToken())] = false;
		}
		int cnt = 0;
		for(int i = 1; i<=N; i++) {
			if(parent[i][0] == 0 || parent[i][1] == 0) continue;
			if(chk[i] && chk[parent[i][0]] && chk[parent[i][1]])
				cnt++;
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

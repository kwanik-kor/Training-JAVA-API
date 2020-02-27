package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ACM_ICPC11946 {
	static int N, M, Q;
	static Team teams[];
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		teams = new Team[N];
		for(int i = 0; i<N; i++)
			teams[i] = new Team(i+1, 0, 0);
		for(int q = 0; q<Q; q++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int team = Integer.parseInt(st.nextToken()) - 1;
			int question = Integer.parseInt(st.nextToken());
			String type = st.nextToken();
			if(type.equals("AC")) {
				if(!teams[team].q[question]) {
					teams[team].count++;
					teams[team].q[question] = true;
					teams[team].score += time + teams[team].penalty[question] * 20;
				}
			}else {
				if(!teams[team].q[question])
					teams[team].penalty[question]++;
			}
		}
		Arrays.sort(teams);
		for(int i = 0; i<N; i++)
			bw.write(teams[i].teamNo + " " + teams[i].count + " " + teams[i].score + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Team implements Comparable<Team>{
		int teamNo;
		int score;
		int count;
		int penalty[];
		boolean q[];
		
		public Team(int teamNo, int score, int count) {
			this.teamNo = teamNo;
			this.score = score;
			this.count = count;
			this.penalty = new int[N+1];
			this.q = new boolean[M+1];
		}

		@Override
		public int compareTo(Team t) {
			if(this.count == t.count)
				return this.score - t.score;
			return t.count - this.count;
		}
		
	}
}

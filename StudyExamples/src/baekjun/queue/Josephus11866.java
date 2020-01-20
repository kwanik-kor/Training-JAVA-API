package baekjun.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder("<");
		for(int i = 1; i<=N; i++)
			q.offer(i);
		while(q.size() != 0) {
			cnt = 0;
			while(true) {
				cnt++;
				if(cnt != K)
					q.offer(q.poll());
				if(cnt == K) {
					sb = (q.size() == 1)? sb.append(q.poll()) : sb.append(q.poll() + ", ");
					break;
				}
			}
		}
		bw.write(sb.append(">").toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

package baekjun.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class RotatingQueue1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Integer> dq = new LinkedList<>();
		for(int i = 1; i<=N; i++)
			dq.add(i);
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i = 0; i<M; i++) {
			int n = Integer.parseInt(st.nextToken());
			int flag = 0;
			for(int j = 0; j<dq.size(); j++) {
				if(dq.get(j) == n) {
					flag = j;
					break;
				}
			}
			if(flag <= dq.size()/2) {
				for(int j = 0; j<flag; j++) {
					dq.addLast(dq.poll());
					sum++;
				}
				dq.poll();
			}else {
				for(int j = 0; j<dq.size()-flag; j++) {
					dq.addFirst(dq.pollLast());
					sum++;
				}
				dq.poll();
			}
		}
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		br.close();
	}

}

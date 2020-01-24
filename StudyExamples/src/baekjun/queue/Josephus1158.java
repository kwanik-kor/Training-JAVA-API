package baekjun.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder result = new StringBuilder("<");
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<=N; i++) q.add(i);
		
		int cnt = 0;
		while(!q.isEmpty()) {
			cnt++;
			if(cnt == K){
				if(q.size() == 1) {
					result.append(q.poll() + ">");
					break;
				}
				else result.append(q.poll() + ", ");
				cnt = 0;
			}else 
				q.add(q.poll());
		}
		
		bw.write(result.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

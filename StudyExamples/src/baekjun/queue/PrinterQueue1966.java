package baekjun.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PrinterQueue1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			q.clear();
			boolean chk;
			int cnt = 0;
			
			for(int i = 0; i<N; i++)
				q.offer(Integer.parseInt(st.nextToken()));
			
			while(!q.isEmpty()) {
				chk = true;
				for(int i = 1; i<q.size(); i++) {
					if(q.peek() < q.get(i)){
						chk = false;
						break;
					}
				}
				if(chk) {
					cnt++;
					q.poll();
					if(M == 0)
						break;
					else
						M--;
				}else {
					q.offer(q.poll());
					M = (M == 0)? q.size()-1 : M-1;
				}
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

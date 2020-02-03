package baekjun.priority_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap11279 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int n = 0; n<N; n++) {
			int x = Integer.parseInt(br.readLine());
			if(x != 0) pq.offer(x);
			else {
				if(pq.isEmpty()) bw.write("0\n");
				else bw.write(pq.poll() + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

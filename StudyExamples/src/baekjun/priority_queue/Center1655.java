package baekjun.priority_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Center1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> max = new PriorityQueue<>();
		Queue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
		for(int t = 0; t<N; t++) {
			int x = Integer.parseInt(br.readLine());
			max.offer(x);
			if((max.size() + min.size()) % 2 != 0)
				min.offer(max.poll());
			else if(min.peek() > x) {
				max.offer(min.poll());
				min.offer(max.poll());
			}
			bw.write(min.peek()+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

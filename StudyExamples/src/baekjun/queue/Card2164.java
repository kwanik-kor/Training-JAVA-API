package baekjun.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Card2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i<=N; i++) {
			queue.add(i);
		}
		while(queue.size() != 1) {
			queue.poll();
			if(queue.size() == 1) break;
			queue.add(queue.poll());
		}
		bw.write(String.valueOf(queue.poll()));
		bw.flush();
		bw.close();
		br.close();
	}

}

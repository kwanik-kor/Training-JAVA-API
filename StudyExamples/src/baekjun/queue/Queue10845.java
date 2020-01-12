package baekjun.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue q = new LinkedList();
		int N = Integer.parseInt(br.readLine());
		int last = 0;
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				last = Integer.parseInt(st.nextToken());
				q.offer(last);
				break;
			case "pop":
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.poll());
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				if(q.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "front":
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.peek());
				break;
			case "back":
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(last);
				break;
			}
			 
		}
	}
}

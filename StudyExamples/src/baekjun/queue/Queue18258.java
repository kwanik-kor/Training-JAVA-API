package baekjun.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue18258 {
	static StringBuilder sb = new StringBuilder();
	static Queue q = new ArrayDeque();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push": push(Integer.parseInt(st.nextToken())); break;
			case "pop": pop(); break;
			case "size": size(); break;
			case "empty": empty(); break;
			case "front": front(); break;
			case "back": back(); break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	static void push(int n) {
		q.add(n);
	}
	static void pop() {
		if(q.size() == 0)
			sb.append(-1 + "\n");
		else
			sb.append(q.poll() + "\n");
	}
	static void size() {
		sb.append(q.size() + "\n");
	}
	static void empty() {
		if(q.size() == 0)
			sb.append(1 + "\n");
		else
			sb.append(0 + "\n");
	}
	static void front() {
		int a = (q.size() == 0)? -1 : (int) ((ArrayDeque) q).getFirst();
		sb.append(a + "\n");
	}
	static void back() {
		int a = (q.size() == 0)? -1 : (int) ((ArrayDeque) q).getLast();
		sb.append(a + "\n");
	}
}

package baekjun.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Dequeue10866 {
	static ArrayDeque<Integer> dq = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push_back": pushBack(Integer.parseInt(st.nextToken())); break;
			case "push_front": pushFront(Integer.parseInt(st.nextToken())); break;
			case "pop_back": popBack(); break;
			case "pop_front": popFront(); break;
			case "size": size(); break;
			case "empty": empty(); break;
			case "front": front(); break;
			case "back": back(); break;
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void pushBack(int n) {
		dq.addLast(n);
	}
	static void pushFront(int n) {
		dq.addFirst(n);
	}
	static void popFront() {
		sb = (dq.isEmpty())? sb.append("-1\n") : sb.append(dq.pollFirst() + "\n");
	}
	static void popBack() {
		sb = (dq.isEmpty())? sb.append("-1\n") : sb.append(dq.pollLast() + "\n");
	}
	static void size() {
		sb.append(dq.size() + "\n");
	}
	static void empty() {
		sb = (dq.isEmpty())? sb.append("1\n") : sb.append("0\n");
	}
	static void front() {
		sb = (dq.isEmpty())? sb.append("-1\n") : sb.append(dq.peekFirst() + "\n");
	}
	static void back() {
		sb = (dq.isEmpty())? sb.append("-1\n") : sb.append(dq.peekLast() + "\n");
	}
}

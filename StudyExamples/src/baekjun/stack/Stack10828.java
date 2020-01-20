package baekjun.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack10828 {
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
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
			case "top": top(); break;
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void push(int n) {
		stack.push(n);
	}
	static void pop() {
		sb.append(((stack.empty())? -1 : stack.pop()) + "\n");
	}
	static void size() {
		sb.append(stack.size() + "\n");
	}
	static void empty() {
		sb.append(((stack.empty())? 1 : 0) + "\n");
	}
	static void top() {
		sb.append(((stack.empty())? -1: stack.peek()) + "\n");
	}
}

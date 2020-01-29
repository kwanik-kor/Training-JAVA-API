package baekjun.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Editor1406 {
	static Stack<String> left = new Stack<>();
	static Stack<String> right = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		for(int i = 0; i<s.length(); i++)
			left.push(s.substring(i,i+1));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "L":
				if(!left.isEmpty()) right.push(left.pop());
				break;
			case "D":
				if(!right.isEmpty()) left.push(right.pop());
				break;
			case "B": 
				if(!left.isEmpty()) left.pop();
				break;
			case "P": 
				left.push(st.nextToken());
				break;
			}
		}
		while(!left.isEmpty())
			right.push(left.pop());
		while(!right.isEmpty())
			bw.write(right.pop());
		bw.flush();
		bw.close();
		br.close();
	}

}

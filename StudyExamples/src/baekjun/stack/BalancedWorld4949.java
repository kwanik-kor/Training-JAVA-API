package baekjun.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BalancedWorld4949 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		Stack<String> stack;
		boolean chk;
		while(!(s=br.readLine()).equals(".")) {
			stack = new Stack<>();
			chk = true;
			for(int i = 0; i<s.length(); i++) {
				if(s.charAt(i) == '(' || s.charAt(i) == '[')
					stack.push(String.valueOf(s.charAt(i)));
				if(s.charAt(i) == ']') {
					if(!stack.isEmpty() && stack.peek().equals("["))
						stack.pop();
					else {
						chk = false;
						break;
					}
				}
				if(s.charAt(i) == ')') {
					if(!stack.isEmpty() && stack.peek().equals("("))
						stack.pop();
					else {
						chk = false;
						break;
					}
				}
			}
			if(!stack.isEmpty()) chk = false;
			if(chk) bw.write("yes\n");
			else bw.write("no\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

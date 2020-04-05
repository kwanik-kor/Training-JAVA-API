package line.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class A {
	static Stack<Character> stack = new Stack<>();
	
	static boolean chk(char open, char close) {
		if(stack.size() == 0) 
			return false;
		if(stack.peek() == open) {
			stack.pop();
			return true;
		}
		return false;
	}
	
	static int solve(String inputString) {
		char carr[] = inputString.toCharArray();
		int cnt = 0;
		for(int i = 0; i<carr.length; i++) {
			if(carr[i] == '(' || carr[i] == '{' || carr[i] == '[' || carr[i] == '<')
				stack.add(carr[i]);
			if(carr[i] == ')') {
				if(!chk('(', ')')) {
					cnt = -1;
					break;
				}else cnt++;
			}else if(carr[i] == '}') {
				if(!chk('{', '}')) {
					cnt = -1;
					break;
				}else cnt++;
			}else if(carr[i] == ']') {
				if(!chk('[', ']')) {
					cnt = -1;
					break;
				}else cnt++;
			}else if(carr[i] == '>') {
				if(!chk('<', '>')) {
					cnt = -1;
					break;
				}else cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = br.readLine();
		System.out.println(solve(inputString));
	}

}

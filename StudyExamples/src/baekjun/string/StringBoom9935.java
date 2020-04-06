package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class StringBoom9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		for(int i = str.length()-1; i>=0; i--) {
			boolean isBomb = false;
			char c = str.charAt(i);
			stack.push(c);
			if(c == bomb.charAt(0) && stack.size() >= bomb.length()) {
				isBomb = true;
				for(int j = 0; j<bomb.length(); j++) {
					if(bomb.charAt(j) != stack.get(stack.size() - 1 - j)) {
						isBomb = false;
						break;
					}
				}
				if(isBomb) {
					for(int j = 0; j<bomb.length(); j++)
						stack.pop();
				}
			}
		}
		StringBuffer sb = new StringBuffer("");
		if(stack.isEmpty())
			sb = new StringBuffer("FRULA");
		else {
			while(!stack.isEmpty())
				sb.append(stack.pop());
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

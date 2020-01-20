package baekjun.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Bracket9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		Stack<String> stack;
		for(int i = 0; i<T; i++) {
			String s = br.readLine();
			stack = new Stack<>();
			boolean isVPS = true;
			for(int k =0; k<s.length(); k++) {
				if(s.charAt(k) == '(')
					stack.push("(");
				else {
					if(stack.isEmpty()) {
						isVPS = false;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty()) isVPS = false;
			if(isVPS) bw.write("YES" + "\n");
			else bw.write("NO" + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

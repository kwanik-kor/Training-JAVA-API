package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class GoodWord3986 {
	
	static boolean isGoodWord(String s) {
		boolean flag = true;
		Stack<Character> stack = new Stack<Character>();
		stack.push(s.charAt(0));
		for(int i = 1; i<s.length(); i++) {
			char c = s.charAt(i);
			if(stack.isEmpty() || stack.get(stack.size() - 1) != c)
				stack.push(c);
			else
				stack.pop();
		}
		if(!stack.isEmpty()) flag = false;
		return flag;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		while(N-- > 0) {
			String str = br.readLine();
			if(isGoodWord(str)) ans++;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

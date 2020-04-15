package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.TreeSet;

public class DeleteBracket2800 {
	static String str, ret = "";
	static int bracketCnt = 0;
	static int match[] = new int[221];
	static boolean erased[] = new boolean[221];
	static TreeSet<String> set = new TreeSet<>();
	
	static void erase(int cur) {
		if(cur == str.length()) {
			set.add(ret);
			return;
		}
		if(str.charAt(cur) == '(') {
			erased[match[cur]] = true;
			erase(cur + 1);
			erased[match[cur]] = false;
		}
		if(str.charAt(cur) == ')' && erased[cur])
			erase(cur + 1);
		else {
			ret += str.charAt(cur);
			erase(cur + 1);
			ret = ret.substring(0, ret.length() - 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = br.readLine();
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(')
				st.push(i);
			else if(c == ')') {
				int n = st.pop();
				match[i] = n;
				match[n] = i;
				bracketCnt++;
			}
		}
		erase(0);
		for(String s : set) {
			if(s.equals(str)) continue;
			bw.write(s + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}

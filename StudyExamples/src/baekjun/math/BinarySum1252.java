package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BinarySum1252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		int len = Math.max(s1.length(), s2.length()) + 1;
		int n1[] = new int[len];
		int n2[] = new int[len];
		int ans[] = new int[len];
		for(int i = 0; i <s1.length(); i++)
			n1[i] = s1.charAt(s1.length() - 1 - i) - '0';
		for(int i = 0; i < s2.length(); i++)
			n2[i] = s2.charAt(s2.length() - 1 - i) - '0';
		
		int flag = 0;
		for(int i = 0; i < len; i++) {
			if(n1[i] + n2[i] + flag >= 2) {
				ans[i] = (n1[i] + n2[i] + flag) % 2;
				flag = 1;
			}else {
				ans[i] = n1[i] + n2[i] + flag;
				flag = 0;
			}
		}
		
		boolean firstOne = false;
		for(int i = len - 1; i>=0; i--) {
			if(!firstOne && i == 0) {
				bw.write(ans[i]+ "");
				break;
			}
			if(!firstOne) {
				if(ans[i] == 1) {
					firstOne = true;
					bw.write(ans[i] + "");
				}
			}else {
				bw.write(ans[i] + "");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

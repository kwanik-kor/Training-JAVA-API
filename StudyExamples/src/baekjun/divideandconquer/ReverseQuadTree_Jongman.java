package baekjun.divideandconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReverseQuadTree_Jongman {
	static int idx;
	
	static String recursive(String str) {
		idx++;
		char c = str.charAt(idx);
		if(c == 'b' || c == 'w') return c + "";
		
		String leftTop = recursive(str);
		String rightTop = recursive(str);
		String leftBottom = recursive(str);
		String rightBottom = recursive(str);
		
		return "x" + leftBottom + rightBottom + leftTop + rightTop;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			idx = -1;
			String str = br.readLine();
			bw.write(recursive(str) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

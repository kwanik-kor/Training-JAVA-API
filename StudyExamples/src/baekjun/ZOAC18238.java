package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZOAC18238 {
	static int sum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = 'A' + br.readLine();
		for(int i = 0; i<s.length()-1; i++) {
			int gap = Math.abs(s.charAt(i+1) - s.charAt(i));
			sum += (gap <= 13)? gap : (26 - gap);
		}
		System.out.println(sum);
	}

}

package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WhatATwist11947 {
	static long calc(long N) {
		String s = String.valueOf(N);
		String tmp = "";
		for(int i = 0; i<s.length(); i++)
			tmp += 9 - (s.charAt(i) - '0');
		return N * Long.parseLong(tmp);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			int N = Integer.parseInt(br.readLine());
			for(long i = 10; true; i*=10) {
				if(N < i) {
					if(N < i/2) bw.write(calc(N) + "\n");
					else bw.write(calc(i/2) + "\n");
					break;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

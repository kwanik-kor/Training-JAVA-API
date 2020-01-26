package baekjun.functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star2448 {
	static int N;
	static String star[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		star = new String[N];
		star[0] = "  *  ";
		star[1] = " * * ";
		star[2] = "*****";
		printStar();
		br.close();
	}
	
	static void printStar() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int k = 1; 3*Math.pow(2, k) <= N; k++) {
			int bottom = (int)(3 * Math.pow(2, k));
			int middle = bottom/2;
			for(int i = middle; i<bottom; i++)
				star[i] = star[i - middle] + " " + star[i - middle];
			String space = "";
			for(int i = 0; i < middle; i++)
				space += " ";
			for(int i = 0; i < middle; i++)
				star[i] = space + star[i] + space;
		}
		
		for(int i = 0; i<N; i++) {
			bw.write(star[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

}

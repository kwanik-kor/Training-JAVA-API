package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Big7568 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] w = new int[N];
		int[] h = new int[N];
		int[] result = new int[N];
		Arrays.fill(result, 1);
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			w[i] = Integer.parseInt(s.split(" ")[0]);
			h[i] = Integer.parseInt(s.split(" ")[1]);
		}
		
		for(int i = 0; i<N-1; i++) {
			for(int j = i+1; j<N; j++) {
				if(w[i] > w[j] && h[i] > h[j])
					result[j]++;
				else if(w[i] < w[j] && h[i] < h[j])
					result[i]++;
			}
		}
		for(int i = 0 ; i<N; i++)
			bw.write(result[i] + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}

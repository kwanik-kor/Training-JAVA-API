package baekjun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Perfection6491 {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int N;
		while((N=sc.nextInt()) != 0) {
			int sum = 0;
			for(int j = 1; j<=Math.sqrt(N); j++) {
				if(N%j == 0) {
					if(j == Math.sqrt(N))
						sum += j;
					else
						sum += j + N/j;
				}
			}
			if(sum-N == N)
				bw.write(String.format("%d PERFECT\n", N));
			else if(sum-N < N)
				bw.write(String.format("%d DEFICIENT\n", N));
			else
				bw.write(String.format("%d ABUNDANT\n", N));
		}
		bw.flush();
		bw.close();
	}

}

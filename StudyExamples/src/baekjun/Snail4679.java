package baekjun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Snail4679 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			int H = sc.nextInt();
			if(H == 0) break;
			float U = sc.nextInt();
			int D = sc.nextInt();
			int F = sc.nextInt();
			int day = 1;
			float sum = U - D;
			float fa = U*F/100f;
			if(U <= H && sum > 0) {
				while(sum <= H) {
					day++;
					U -= fa;
					sum += U;
					if(sum > H) break;
					sum -= D;
					if(sum < 0) break;
				}
			}
			bw.write((sum < H) ? String.format("failure on day %d\n", day) : String.format("success on day %d\n", day));
		}
		bw.flush();
		bw.close();
	}

}

package baekjun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CalcE6376 {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("n e\n- -----------\n");
		for(int i = 0; i<3; i++) {
			float result = 1;
			if(i==2) {
				for(int j = 1; j<=i; j++) {
					result += (1/factorial(j));
				}
				bw.write(i + " " + result+ "\n");
			}
			else {
				for(int j = 1; j<=i; j++) {
					result += (int)(1/factorial(j));
				}
				bw.write(i + " " + (int)result+ "\n");
			}
		}
		for(int i = 3; i<10; i++) {
			double result = 1;
			for(int j = 1; j<=i; j++) {
				result += 1/factorial(j);
			}
			bw.write(i + " " + String.format("%.9f", result) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static double factorial(int n) {
		if(n == 1 || n == 0)
			return n;
		return n * factorial(n-1);
	}
}

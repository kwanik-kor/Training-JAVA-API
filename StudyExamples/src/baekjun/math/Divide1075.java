package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Divide1075 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		for(int i = (N/100)*100; i<((N/100)+1)*100; i++) {
			if(i % F == 0) {
				int nmg = i%100;
				if(nmg < 10) bw.write("0" + nmg);
				else bw.write(nmg+"");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

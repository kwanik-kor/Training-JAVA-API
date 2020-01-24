import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i<=2*N-1; i++) {
			if(i<N) {
				for(int j = 1; j<=i; j++)
					bw.write("*");
				for(int j = 1; j<=2*N - i*2; j++)
					bw.write(" ");
				for(int j = 1; j<=i; j++)
					bw.write("*");
			}else if(i>N) {
				for(int j = 1; j<=2*N - i; j++)
					bw.write("*");
				for(int j = 1; j<=2*(N - 2*N + i); j++)
					bw.write(" ");
				for(int j = 1; j<=2*N - i; j++)
					bw.write("*");
			}else {
				for(int j = 1; j<=2*N; j++)
					bw.write("*");
			}
			
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

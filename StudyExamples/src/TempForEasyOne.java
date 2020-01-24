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
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N-(i+1); j++)
				bw.write(" ");
			for(int j = 0; j<2*(i+1)-1; j++) {
				if(j == 0 || j == 2*i)
					bw.write("*");
				else
					bw.write(" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

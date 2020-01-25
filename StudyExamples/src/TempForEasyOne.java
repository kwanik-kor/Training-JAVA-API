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
		int flag = 1;
		for(int i = 1; i<=2*N-1; i++) {
			for(int j = 1; j<=4*N-3; j++) {
				if((i == 1 || i == 2*N-1) && (j<=N || j>=3*N-2))
					bw.write("*");
				else if(j == flag || j == 4*N-2 - flag || j == flag + N -1 || j == 3*N - 1 - flag)
					bw.write("*");
				else if(j == 4*N - 1 - flag)
					break;
				else
					bw.write(" ");
			}
			if(i<=N-1) flag++;
			else flag--;
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

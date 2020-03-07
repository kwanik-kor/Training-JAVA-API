import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TempClass {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result[][] = new int[N][M];
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			int tmp = -1;
			for(int j = 0; j<M; j++) {
				if(s.charAt(j) == 'c') {
					tmp = 0;
					result[i][j] = tmp;
				}else {
					if(tmp == -1) result[i][j] = tmp;
					else result[i][j] = ++tmp;
				}
				
				bw.write(result[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

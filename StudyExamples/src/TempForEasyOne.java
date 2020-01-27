import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int total = 0;
		for(int i = 1; i <= N; i++) {
			boolean chk = false;
			for(int j = 0; j<M; j++) {
				if(i % arr[j] == 0) {
					chk = true;
					break;
				}
			}
			if(chk) total += i;
		}
		
		bw.write(total + "");
		bw.flush();
		bw.close();
		br.close();
	}
}

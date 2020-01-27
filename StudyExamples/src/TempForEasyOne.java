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
		int arr[] = new int[N];
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		for(int m = 0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int min = 1000000001;
			int max = 0;
			for(int i = a-1; i<b; i++) {
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
			}
			bw.write(min + " " + max + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

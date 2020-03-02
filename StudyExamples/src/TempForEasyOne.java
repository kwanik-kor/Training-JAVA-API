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
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N+1];
		arr[0] = 500001;
		for(int i = 1; i<=N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
			for(int j = i-1; j>=0; j--) {
				if(arr[j] >= n) {
					bw.write(j + " ");
					break;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

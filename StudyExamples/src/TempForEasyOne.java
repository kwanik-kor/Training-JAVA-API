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
		int testCase = Integer.parseInt(br.readLine());
		int arr[] = new int[7];
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int total = 0;
			int min = Integer.MAX_VALUE;
			for(int i = 0; i<7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] % 2 == 0) {
					total += arr[i];
					min = Math.min(arr[i], min);
				}
			}
			bw.write(total + " " + min + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

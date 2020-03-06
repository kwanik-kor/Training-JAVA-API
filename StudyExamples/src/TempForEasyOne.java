import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[5];
			for(int i = 0; i<5; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			if(arr[3] - arr[1] >= 4) bw.write("KIN\n");
			else bw.write(arr[1] + arr[2] + arr[3] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

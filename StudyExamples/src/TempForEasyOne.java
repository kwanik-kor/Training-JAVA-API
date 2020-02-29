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
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int arr[] = new int[1001];
		int flag = 1;
		for(int i = 1; i<=1000; i++) {
			for(int j = 1; j<=flag; j++) {
				if(i > 1000) break;
				arr[i] = flag;
				i++;
			}
			i--;
			flag++;
		}
		int sum = 0;
		for(int i = A; i<=B; i++)
			sum += arr[i];
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int arr[] = new int[9];
		int total = 0;
		for(int i = 0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
		}
		boolean flag = true;
		for(int i = 0; i<8; i++) {
			if(!flag) break;
			for(int j = i+1; j<9; j++) {
				if(total - (arr[i]+arr[j]) == 100) {
					arr[i] = arr[j] = 0;
					flag = false;
					break;
				}
			}
		}
		for(int i = 0; i<9; i++) {
			if(arr[i] != 0) bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

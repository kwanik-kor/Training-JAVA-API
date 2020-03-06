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
		char arr[] = br.readLine().toCharArray();
		char result[] = br.readLine().toCharArray();
		if(N%2 != 0) {
			for(int i = 0; i<arr.length; i++) 
				arr[i] = (char)((arr[i] ^ '1') + '0');
		}
		boolean flag = true;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] != result[i]) {
				flag = false;
				break;
			}
		}
		if(flag) bw.write("Deletion succeeded");
		else bw.write("Deletion failed");
		bw.flush();
		bw.close();
		br.close();
	}
}

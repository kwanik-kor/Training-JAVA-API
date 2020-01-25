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
		int length = 1 + 4 *(N - 1);
		String arr[][] = new String[length][length];
		for(int i = 0; i<length/2+1; i+=2) {
			for(int j = i; j<length-i; j++) {
				for(int k = i; k<length-i; k++) {
					if(j != i && j != length-1-i && k != i && k != length-1-i)
						arr[j][k] = " ";
					else
						arr[j][k] = "*";
				}
			}
		}
		for(int i = 0; i<length; i++) {
			for(int j = 0; j<length; j++){
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

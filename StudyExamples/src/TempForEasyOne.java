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
		for(int t = 0; t<3; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A[] = new int[3];
			int B[] = new int[3];
			int C[] = new int[3];
			for(int i = 0; i<3; i++)
				A[i] = Integer.parseInt(st.nextToken());
			for(int i = 0; i<3; i++)
				B[i] = Integer.parseInt(st.nextToken());
			int flag = 0;
			if(B[2]-A[2] >= 0) C[2] = B[2] - A[2];
			else {
				C[2] = B[2] + 60 - A[2];
				flag = 1;
			}
			if(B[1] - (A[1]+flag)>=0) {
				C[1] = B[1] - (A[1]+flag);
				flag = 0;
			}else {
				C[1] = B[1] + 60 - (A[1]+flag);
				flag = 1; 
			}
			if(B[0] - (A[0] + flag)>=0) C[0] = B[0] - (A[0] + flag);
			else C[0] = B[0] + 24 - (A[0] + flag);
			for(int i = 0; i<3; i++)
				bw.write(C[i] + " ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

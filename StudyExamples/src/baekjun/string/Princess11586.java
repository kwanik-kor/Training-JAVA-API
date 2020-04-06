package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Princess11586 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String arr[] = new String[N];
		for(int i = 0; i<N; i++)
			arr[i] = br.readLine();
		int type = Integer.parseInt(br.readLine());
		if(type == 1) {
			for(int i = 0; i<N; i++)
				bw.write(arr[i] + "\n");
		}else if(type == 2) {
			for(int i = 0; i<N; i++)
				bw.write(new StringBuffer(arr[i]).reverse().toString() + "\n");
		}else
			for(int i = N-1; i>=0; i--)
				bw.write(arr[i] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}

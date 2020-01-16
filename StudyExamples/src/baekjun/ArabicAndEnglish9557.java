package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ArabicAndEnglish9557 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String arr[];
		int n;
		for(int k = 0; k<T; k++) {
			n = Integer.parseInt(br.readLine()); 
			arr = new String[n];
			st = new StringTokenizer(br.readLine());
			int engIdx = -1;
			for(int i = 0; i<n; i++) {
				arr[i] = st.nextToken();
				if(arr[i].charAt(0) >= 97 && arr[i].charAt(0) <= 122)
					engIdx = i;
			}
			
			if(engIdx < 0) {
				for(int i = 0; i<n; i++)
					bw.write(arr[i] + " ");
			}else {
				for(int i = engIdx+1; i<n; i++)
					bw.write(arr[i] + " ");
				bw.write(arr[engIdx] + " ");
				for(int i = 0; i<engIdx; i++)
					bw.write(arr[i] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

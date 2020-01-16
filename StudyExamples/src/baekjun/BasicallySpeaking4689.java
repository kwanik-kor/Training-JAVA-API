package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BasicallySpeaking4689 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s = "";
		while((s = br.readLine()) != null) {
			st = new StringTokenizer(s);
			char arr[] = st.nextToken().toCharArray();
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int len = arr.length;
			int dec = 0;
			for(int i = len - 1; i>=0; i--) {
				int num = (int)arr[i] - '0';
				if(arr[i]>=65)
					num -= 7;
				dec += num*Math.pow(n, len - 1 - i); 
			}
			char result[] = new char[7];
			int cnt = 0;
			if(dec == 0)
				result[6] = '0';
			else {
				while(dec > 0) {
					if(cnt == 7) {
						result[0] = result[1] = ' ';
						result[2] = 'E'; 
						result[3] = result[4] = result[6] = 'R'; 
						result[5] = 'O';
						break;
					}
					if(dec%m >= 10)
						result[6-cnt] = (char)(dec%m + '0' + 7);
					else
						result[6-cnt] = (char)(dec%m + '0');
					dec /= m;
					cnt++;
				}
			}
			
			for(int i = 0; i<7; i++)
				bw.write(result[i]);
			bw.write("\n");
			bw.flush();
		}
		
		bw.close();
		br.close();
	}

}

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
		String song[] = {"baby", "sukhwan", "tururu", "turu", "very", "cute", "tururu", "turu", "in", "bed", "tururu", "turu", "baby", "sukhwan"};
		if(N/14 >= 3 && ((N-1)%14 == 2 || (N-1)%14 == 6 || (N-1)%14 == 10)) {
			bw.write(String.format("tu+ru*%d", N/14 + 2));
		}else if(N/14 >= 4 && ((N-1)%14 == 3 || (N-1)%14 == 7 || (N-1)%14 == 11)) {
			bw.write(String.format("tu+ru*%d", N/14 + 1));
		}else {
			String s = song[(N-1)%14];
			if(s.contains("tu")) {
				for(int i = 0; i<N/14; i++)
					s+= "ru";
			}
			bw.write(s);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

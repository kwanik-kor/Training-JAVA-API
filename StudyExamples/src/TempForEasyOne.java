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
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int a = 0;
		int b = 0;
		for(int i = 0; i<10; i++) {
			int a_1 = Integer.parseInt(st1.nextToken());
			int b_1 = Integer.parseInt(st2.nextToken());
			if(a_1 > b_1) a++;
			else if(a_1 < b_1) b++;
		}
		if(a == b) bw.write("D");
		else if(a < b) bw.write("B");
		else bw.write("A");
		bw.flush();
		bw.close();
		br.close();
	}
}
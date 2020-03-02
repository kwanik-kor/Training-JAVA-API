import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int dice[] = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<3; i++)
			dice[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(dice);
		if(dice[0] == dice[1] && dice[1] == dice[2])
			bw.write(10000 + dice[0]*1000 + "");
		else if(dice[0] == dice[1] || dice[1] == dice[2])
			bw.write(1000 + dice[1]*100 + "");
		else bw.write(dice[2]*100 + "");
		bw.flush();
		bw.close();
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			set.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i = 0; i<M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(set.contains(n)) cnt++;
			set.add(n);
		}
		bw.write(set.size() - cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}

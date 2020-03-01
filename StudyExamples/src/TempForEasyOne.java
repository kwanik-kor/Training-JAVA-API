import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		ArrayList<String> result = new ArrayList<>();
		for(int i = 0; i<N; i++) 
			set.add(br.readLine());
		for(int i = 0; i<M; i++) {
			String name = br.readLine();
			if(set.contains(name)) result.add(name);
		}
		Collections.sort(result);
		bw.write(result.size() + "\n");
		for(String s : result)
			bw.write(s + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

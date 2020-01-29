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
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i<N; i++)
			list.add(Integer.parseInt(st.nextToken()));
		HashSet<Integer> temp = new HashSet<>(list);
		list = new ArrayList<>(temp);
		Collections.sort(list);
		for(Integer i : list)
			bw.write(i + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i<N; i++) {
			String title = br.readLine();
			if(map.containsKey(title)) map.replace(title, map.get(title) + 1);
			else map.put(title, 1);
		}
		List<String> keyList = new ArrayList<>(map.keySet());
		keyList.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(map.get(s1).compareTo(map.get(s2)) == 0)
					return s1.compareTo(s2);
				return map.get(s2).compareTo(map.get(s1));
			}
		});
		bw.write(keyList.get(0));
		bw.flush();
		bw.close();
		br.close();
	}
}

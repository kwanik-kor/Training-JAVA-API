package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Card11652 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<>();
		for(int i = 0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			if(!map.containsKey(num))
				map.put(num, 1);
			else 
				map.replace(num, map.get(num) + 1);
		}
		List<Long> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, new Comparator<Long>() {
			@Override
			public int compare(Long a, Long b) {
				if(map.get(a).compareTo(map.get(b)) == 0)
					return a.compareTo(b);
				return map.get(b).compareTo(map.get(a));
			}
		});
		bw.write(keySetList.get(0) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

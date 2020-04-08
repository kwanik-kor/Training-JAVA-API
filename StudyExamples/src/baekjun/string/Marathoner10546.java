package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Marathoner10546 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> people = new ArrayList<String>();
		for(int i = 0; i<N; i++)
			people.add(br.readLine());
		Collections.sort(people);
		for(int i = 0; i<N-1; i++) {
			String name = br.readLine();
			int idx = Collections.binarySearch(people, name);
			if(idx >= 0) people.remove(idx);
		}
		bw.write(people.get(0));
		bw.flush();
		bw.close();
		br.close();
				
	}

}

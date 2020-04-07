package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fox9536 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		while(testCase-- > 0) {
			String[] sounds = br.readLine().split(" ");
			String animal = "";
			while(!(animal = br.readLine()).equals("what does the fox say?")) {
				String type = animal.split(" ")[2];
				for(int i = 0; i<sounds.length; i++) {
					if(sounds[i].equals(type))
						sounds[i] = "Nope";
				}
			}
			for(String s : sounds) {
				if(!s.equals("Nope"))
					bw.write(s + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

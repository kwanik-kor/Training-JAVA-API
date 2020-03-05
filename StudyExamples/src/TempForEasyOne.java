import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		while(!(s = br.readLine()).equals("*")) {
			if(s.length() < 26) bw.write("N\n");
			else {
				HashSet<Character> set = new HashSet<>();
				s = s.replace(" ", "");
				for(int i = 0; i<s.length(); i++) 
					set.add(s.charAt(i));
				if(set.size() != 26) bw.write("N\n");
				else bw.write("Y\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

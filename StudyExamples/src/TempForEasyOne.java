import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int happy = 0;
		int sad = 0;
		for(int i = 0; i<s.length() - 2; i++) {
			if(s.substring(i, i+3).equals(":-)")) happy++;
			else if(s.substring(i, i+3).equals(":-(")) sad++;
		}
		if(happy == 0 && sad == 0) bw.write("none");
		else if(happy == sad) bw.write("unsure");
		else if(happy > sad) bw.write("happy");
		else if(happy < sad) bw.write("sad");
		bw.flush();
		bw.close();
		br.close();
	}
}
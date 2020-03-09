import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	static int octagonal(String s) {
		int result = 0;
		int eight = 1;
		for(int i = s.length() - 1; i>=0; i--) {
			result += (s.charAt(i)-'0')*eight;
			eight *= 8;
		}
		return result;
	}
	
	static int hexagonal(String s) {
		int result = 0;
		int hex = 1;
		for(int i = s.length()-1; i>=0; i--) {
			int val = (s.charAt(i)>='a')? (s.charAt(i)-'a' + 10) : s.charAt(i) - '0';
			result += val*hex;
			hex *= 16;
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		if(s.charAt(0) != '0') bw.write(s);
		else {
			if(s.charAt(1) != 'x') bw.write(octagonal(s.substring(1))+"");
			else bw.write(hexagonal(s.substring(2))+"");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String n1 = br.readLine();
		String oper = br.readLine();
		String n2 = br.readLine();
		int len1 = n1.length();
		int len2 = n2.length();
		if(oper.equals("*")) {
			bw.write("1");
			for(int i = 0; i<len1 + len2 - 2; i++)
				bw.write("0");
		}else {
			if(len1 > len2) {
				bw.write("1");
				for(int i = 0; i<len1-1; i++) {
					if(i == len1-len2-1) bw.write("1");
					else bw.write("0");
				}
			}else if(len2 > len1) {
				bw.write("1");
				for(int i = 0; i<len2-1; i++) {
					if(i == len2-len1-1) bw.write("1");
					else bw.write("0");
				}
			}else {
				bw.write("2");
				for(int i = 0; i<len1-1; i++) 
					bw.write("0");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

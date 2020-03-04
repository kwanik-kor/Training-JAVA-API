import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String binary = br.readLine();
		if(binary.length() % 3 == 1) binary = "00"+binary;
		else if(binary.length() % 3 == 2) binary = "0"+binary;
		for(int i = 0; i<binary.length(); i+=3) {
			char[] tmp = binary.substring(i, i+3).toCharArray();
			int flag = 4;
			int val = 0;
			for(int j = 0; j<3; j++) {
				val += (tmp[j]-'0') * flag;
				flag /= 2;
			}
			bw.write(val+"");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

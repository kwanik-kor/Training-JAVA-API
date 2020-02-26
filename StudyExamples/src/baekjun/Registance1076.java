package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Registance1076 {
	
	static int getVal(String color) {
		int val;
		switch(color) {
			case "black": val = 0; break;
			case "brown": val = 1; break;
			case "red": val = 2; break;
			case "orange": val = 3; break;
			case "yellow": val = 4; break;
			case "green": val = 5; break;
			case "blue": val = 6; break;
			case "violet": val = 7; break;
			case "grey": val = 8; break;
			default: val = 9;
		}
		return val;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = getVal(br.readLine())*10 + getVal(br.readLine());
		String multiple = br.readLine();
		if(ans == 0)
			bw.write("0");
		else {
			bw.write(ans + "");
			for(int i = 0; i<getVal(multiple); i++)
				bw.write("0");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

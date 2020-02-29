package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OctalBinary1212 {
	static String octalToBinary(char c) {
		String result = "";
		switch(c) {
		case '0': result = "000"; break;
		case '1': result = "001"; break;
		case '2': result = "010"; break;
		case '3': result = "011"; break;
		case '4': result = "100"; break;
		case '5': result = "101"; break;
		case '6': result = "110"; break;
		default: result = "111";
		}
		return result;
	}
	
	static String first(char c) {
		String result = "";
		switch(c) {
		case '0': result = ""; break;
		case '1': result = "1"; break;
		case '2': result = "10"; break;
		case '3': result = "11"; break;
		case '4': result = "100"; break;
		case '5': result = "101"; break;
		case '6': result = "110"; break;
		default: result = "111";
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char octal[] = br.readLine().toCharArray();
		if(octal.length == 1 && octal[0] == '0') bw.write("0");
		else {
			for(int i = 0; i<octal.length; i++) {
				if(i == 0) bw.write(first(octal[i]));
				else bw.write(octalToBinary(octal[i]));
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}

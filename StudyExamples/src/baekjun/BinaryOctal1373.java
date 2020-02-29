package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinaryOctal1373 {
	static String binaryToOctal(String s) {
		String result = "";
		switch(s) {
		case "000": result = "0"; break;
		case "001": result = "1"; break;
		case "010": result = "2"; break;
		case "011": result = "3"; break;
		case "100": result = "4"; break;
		case "101": result = "5"; break;
		case "110": result = "6"; break;
		default: result = "7"; break;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String binary = br.readLine();
		if(binary.equals("0")) bw.write("0");
		else {
			if(binary.length() % 3 != 0) {
				if(binary.length() % 3 == 1) bw.write("1");
				else {
					if(binary.charAt(1) == '1') bw.write("3");
					else bw.write("2");
				}
			}
			for(int i = (binary.length()%3); i<binary.length(); i+=3) {
				bw.write(binaryToOctal(binary.substring(i, i+3)));
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

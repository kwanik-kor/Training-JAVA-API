package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class CycleWord1544 {
	static ArrayList<String> list = new ArrayList<String>();
	
	static String rightShift(String str, int size) {
		byte[] orgByte = null;
		byte[] resultByte = new byte[str.length()];
		try {
			orgByte = str.getBytes("ASCII");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int strlen = orgByte.length;
		for(int i = 0; i<strlen; i++)
			resultByte[(i+size)%strlen] = orgByte[i];
		String result = null;
		try {
			result = new String(resultByte, "ASCII");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()) - 1;
		list.add(br.readLine());
		while(N-- > 0) {
			String str = br.readLine();
			int len = str.length();
			boolean newWord = true;
			for(int i = 0; i<len; i++) {
				String shifted = rightShift(str, i);
				for(String s : list) {
					if(shifted.equals(s)) {
						newWord = false;
						break;
					}
				}
				if(!newWord) break;
			}
			if(newWord) list.add(str);
		}
		bw.write(list.size() + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
}

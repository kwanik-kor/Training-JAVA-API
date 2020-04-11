package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Grasshopper10545 {
	static String[] dial = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[10];
		for(int i = 1; i<=9; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		String message = br.readLine();
		int keys[] = new int[message.length() + 1];
		for(int k = 0; k<message.length(); k++) {
			char c = message.charAt(k);
			int origin = 0;
			int idx = 0;
			for(int i = 2; i<=9; i++) {
				if(dial[i].contains(String.valueOf(c))) {
					origin = i;
					keys[k + 1] = i;
					idx = dial[i].indexOf(c);
					break;
				}
			}
			for(int i = 1; i<=9; i++) {
				if(arr[i] == origin) {
					if(keys[k] == keys[k+1])
						bw.write("#");
					for(int j = 0; j<=idx; j++)
						bw.write(i + "");
					break;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

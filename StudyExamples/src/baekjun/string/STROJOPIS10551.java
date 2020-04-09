package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class STROJOPIS10551 {
	static int arr[] = new int[8];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char carr[] = br.readLine().toCharArray();
		for(int i = 0; i<carr.length; i++) {
			char c = carr[i];
			if(c == '1' ||c == 'Q' || c == 'A' || c == 'Z')
				arr[0]++;
			else if(c == '2' || c == 'W' || c == 'S' || c == 'X')
				arr[1]++;
			else if(c == '3' || c == 'E' || c == 'D' || c == 'C')
				arr[2]++;
			else if(c == '4' || c == 'R' || c == 'F' || c == 'V' || c == '5' || c == 'T' || c == 'G' || c == 'B')
				arr[3]++;
			else if(c == '6' || c == 'Y' || c == 'H' || c == 'N' || c == '7' || c == 'U' || c == 'J' || c == 'M')
				arr[4]++;
			else if(c == '8' || c == 'I' || c == 'K' || c == ',')
				arr[5]++;
			else if(c == '9' || c == 'O' || c == 'L' || c == '.')
				arr[6]++;
			else
				arr[7]++;
		}
		for(int i = 0; i<8; i++)
			bw.write(arr[i] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}

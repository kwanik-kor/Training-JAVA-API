package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ggenddo2966 {
	static char[][] arr = {
			{'A', 'B', 'C'},
			{'B', 'A', 'B', 'C'},
			{'C', 'A', 'B'}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char question[] = br.readLine().toCharArray();
		int Adrian = 0;
		int Bruno = 0;
		int Goran = 0;
		for(int i = 0; i<N; i++) {
			char ans = question[i];
			if(ans == arr[0][i % 3])
				Adrian++;
			if(ans == arr[1][i % 4])
				Bruno++;
			if(ans == arr[2][(i / 2) % 3])
				Goran++;
		}
		if(Adrian == Bruno && Bruno == Goran)
			bw.write(Adrian + "\nAdrian\nBruno\nGoran");
		else if(Adrian == Bruno && Bruno > Goran)
			bw.write(Adrian + "\nAdrian\nBruno");
		else if(Bruno == Goran && Goran > Adrian)
			bw.write(Bruno + "\nBruno\nGoran");
		else if(Adrian == Goran && Goran > Bruno)
			bw.write(Adrian + "\nAdrian\nGoran");
		else if(Adrian > Bruno && Adrian > Goran)
			bw.write(Adrian + "\nAdrian");
		else if(Bruno > Adrian && Bruno > Goran)
			bw.write(Bruno + "\nBruno");
		else if(Goran > Adrian && Goran > Bruno)
			bw.write(Goran + "\nGoran");
		bw.flush();
		bw.close();
		br.close();
	}

}

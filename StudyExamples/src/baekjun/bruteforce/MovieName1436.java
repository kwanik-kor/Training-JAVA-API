package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MovieName1436 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = 666;
		while(N>1) {
			num++;
			int cnt = 0;
			for(int i = num; i>0; i/=10) {
				if(i%10 == 6) {
					cnt++;
					if(cnt == 3)
						N--;
				}else
					cnt = 0;
			}
		}
		System.out.println(num);
	}

}

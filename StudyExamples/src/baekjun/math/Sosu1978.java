package baekjun.math;

import java.util.Scanner;

public class Sosu1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			int num = sc.nextInt();
			if(num == 1)
				continue;
			boolean b = true;
			for(int j = 2; j<=Math.sqrt(num); j++) {
				if(num%j == 0)
					b = false;
			}
			if(b)
				cnt++;
		}
		System.out.println(cnt);
	}
}

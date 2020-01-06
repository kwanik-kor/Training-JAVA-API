package baekjun.math;

import java.util.Scanner;

public class AlphaCentauri1011 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i<T; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			long dis = y - x;
			long temp = 0;
			long result = 1;
			while(temp<dis) {
				result++;
				temp += result/2;
			}
			System.out.println(result - 1);
		}
		sc.close();
	}

}

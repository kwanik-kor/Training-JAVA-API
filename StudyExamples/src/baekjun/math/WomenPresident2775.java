package baekjun.math;

import java.util.Scanner;

public class WomenPresident2775 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(count(k, n));
		}
		sc.close();
	}
	public static int count(int k, int n) {
		if(n == 0)
			return 0;
		else if(k == 0)
			return n;
		else
			return count(k-1, n) + count(k, n-1);
	}
}

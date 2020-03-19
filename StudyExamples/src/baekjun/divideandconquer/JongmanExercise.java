package baekjun.divideandconquer;

import java.util.Scanner;

public class JongmanExercise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fastSum(n));
		
	}
	
	static int fastSum(int n) {
		if(n == 1) return 1;
		if(n%2 == 1) return n + fastSum(n-1);
		return 2*fastSum(n/2) + (n/2)*(n/2);
	}
}

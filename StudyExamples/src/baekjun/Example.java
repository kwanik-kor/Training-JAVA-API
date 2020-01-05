package baekjun;

import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(a + b + c - Integer.max(Integer.max(a, b), c) - Integer.min(Integer.min(a, b), c));
	}
}

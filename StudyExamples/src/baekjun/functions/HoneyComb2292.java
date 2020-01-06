package baekjun.functions;

import java.util.Scanner;

public class HoneyComb2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		 
		int i = 0;
		int sum = 1;
		while(true) {
			if(n<=sum)
				break;
			else {
				sum += 6* ++i;
			}
		}
		System.out.println(i+1);
	}
}

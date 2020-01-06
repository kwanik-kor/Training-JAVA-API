package baekjun.math;

import java.util.Scanner;

public class Fraction1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 1;
		int sum = 1;
		while(true) {
			if(n<=sum)
				break;
			else 
				sum += ++i;
		}
		String result = "";
		int gap = sum - n;
		if(i%2 == 0)
			result = (i-gap) + "/" + (1+gap);
		else
			result = (1+gap) + "/" + (i-gap);
		
		System.out.println(result);
	}
}

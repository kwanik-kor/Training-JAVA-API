package baekjun.math;

import java.util.Arrays;
import java.util.Scanner;

public class Bertrand4948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] arr = new boolean[2*123456 + 1];
		Arrays.fill(arr, false);
		arr[1] = true;
		for(int i = 2; i<=Math.sqrt(arr.length); i++) {
			for(int j = 2; i*j < arr.length; j++) {
				arr[i*j] = true;
			}
		}
		
		while(true) {
			int n = sc.nextInt();
			int cnt = 0;
			if(n == 0)
				break;
			else {
				for(int i = n+1; i <= 2*n; i++) {
					if(!arr[i])
						cnt++;
				}
				System.out.println(cnt);
			}
		}
	}

}

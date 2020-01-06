package baekjun.functions;

import java.util.Scanner;

public class Han1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for(int i = 1; i<=n; i++) {
			if(isHanNumber(i))
				cnt++;
		}
		System.out.println(cnt);
	}
	public static boolean isHanNumber(int n) {
		boolean result = true;
		if(n >= 100) {
			String[] arr = String.valueOf(n).split("");
			int gap = Integer.parseInt(arr[1]) - Integer.parseInt(arr[0]);
			for(int i = 1; i < arr.length - 1; i++) {
				if((Integer.parseInt(arr[i+1]) - Integer.parseInt(arr[i])) != gap)
					result = false;
			}
		}
		return result;
	}
}

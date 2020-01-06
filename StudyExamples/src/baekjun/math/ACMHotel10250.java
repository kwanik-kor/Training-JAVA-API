package baekjun.math;

import java.util.Scanner;

public class ACMHotel10250 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i<t; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			int floor = n%h;
			int room = n/h + 1;
			if(n%h == 0) {
				room = n/h;
				floor = h;
			}
			System.out.println(floor*100 + room);
		}
	}

}

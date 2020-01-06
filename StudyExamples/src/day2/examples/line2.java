package day2.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class line2 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("공백 주고 수 입력 : ");
		String nums = sc.nextLine().replaceAll(" ", "");
		int resultNo = sc.nextInt();
		char[] arr = nums.toCharArray();
		
		ArrayList<String> arrl = new ArrayList<String>();
		permutation(arr, 0, arr.length, resultNo, arrl);
	}
	public static void permutation(char[] arr, int start, int end, int resultNo, ArrayList<String> arrl) {
		if(start == end) {
			String s = "";
			for(int i = 0; i < arr.length; i++) {
				s += arr[i];
			}
			arrl.add(s);
			if(arrl.size() == resultNo) {
				Collections.sort(arrl);
				System.out.println("result : " + arrl.get(resultNo-1));
			}
		}else {
			for(int i = start; i < end; i++) {
				swap(arr, start, i);
				permutation(arr, start + 1, end, resultNo, arrl);
				swap(arr, start, i);
			}
		}
		
	}
	public static void swap(char[] arr, int x, int y) {
		char c = arr[x];
		arr[x] = arr[y];
		arr[y] = c;
	}

}

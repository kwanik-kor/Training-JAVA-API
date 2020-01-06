package baekjun.functions;

import java.util.ArrayList;

public class SelfNumber {
	public static void main(String[] args) {
		ArrayList<Integer> nonSelf = nonSelfNumber();
		for(int i = 0; i<10001; i++) {
			if(!nonSelf.contains(i))
				System.out.println(i);
		}
	}
	public static ArrayList<Integer> nonSelfNumber() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < 10001; i++) {
			int a = i;
			String temp = String.valueOf(i);
			for(int j = 0; j<temp.length(); j++) {
				a += Integer.parseInt(temp.substring(j, j + 1));
			}
			arr.add(a);
		}
		return arr;
	}
}

package baekjun.divideandconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Karatsuba_JongMan {
	
	static int[] stringToArr(String s) {
		int arr[] = new int[s.length()];
		for(int i = 0; i<arr.length; i++) 
			arr[i] = s.charAt(i) - '0';
		return arr;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] a = stringToArr(br.readLine());
		int[] b = stringToArr(br.readLine());
	}
	
}

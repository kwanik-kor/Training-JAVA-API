package baekjun.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Statistic2108 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] modeArr = new int[8001];
		for(int i = 0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[i] = n;
			modeArr[n + 4000]++;
		}
		Arrays.sort(arr);
		bw.write(average(arr) + "\n");
		bw.write(middleVal(arr) + "\n");
		bw.write(mode(modeArr, N) + "\n");
		bw.write(arr[N-1] - arr[0] + "");
		bw.flush();
		bw.close();
		br.close();
	}
	static int average(int arr[]) {
		int sum = 0;
		for(int i = 0; i<arr.length; i++)
			sum += arr[i];
		return (int)Math.round((double)sum/arr.length);
	}
	static int middleVal(int arr[]) {
		return arr[arr.length/2];
	}
	static int mode(int modeArr[], int N) {
		int max = 0;
		int[] mode = new int[N];
		int cnt = 0;
		int result = 0;
		for(int i = 0; i<modeArr.length; i++) {
			if(modeArr[i] > max)
				max = modeArr[i];
		}
		for(int i = 0; i<modeArr.length; i++) {
			if(modeArr[i] == max) {
				mode[cnt] = i-4000;
				cnt++;
			}
		}
		if(cnt == 1)
			result = mode[0];
		else {
			result = mode[1];
		}
		
		return result;
	}
}

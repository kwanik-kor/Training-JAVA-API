package baekjun.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SortNumber2751 {
	static int[] sorted;
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		sorted = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(arr, 0, N-1);
		for(int i = 0; i<N; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void mergeSort(int a[], int m, int n) {
		int middle;
		if(m<n) {
			middle = (m + n)/2;
			mergeSort(a, m, middle);
			mergeSort(a, middle+1, n);
			merge(a, m, middle, n);
		}
	}
	
	static void merge(int a[], int m, int mid, int n) {
		int i = m;
		int j = mid + 1;
		int k = m;
		while(i <= mid && j <= n) {
			if(a[i]<=a[j])
				sorted[k++] = a[i++];
			else
				sorted[k++] = a[j++];
		}
		if(i>mid) {
			for(int l = j; l<=n; l++) {
				sorted[k++] = a[l];
			}
		}else {
			for(int l = i; l<=mid; l++) {
				sorted[k++] = a[l];
			}
		}
		for(int l = m; l<=n; l++) {
			a[l] = sorted[l];
		}
	}
}

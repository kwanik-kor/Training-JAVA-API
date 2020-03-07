package baekjun.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class KthNumber11004 {
	static int N, K;
	
	static int partition(int[] arr, int left, int right) {
		int mid = (left + right)/2;
		int pivot = arr[mid];
		swap(arr, left, mid);
		
		int i = left;
		int j = right;
		while(i < j) {
			while(pivot < arr[j]) {
				j--;
			}
			while(i < j && pivot >= arr[i]) {
				i++;
			}
			swap(arr, i, j);
		}
		arr[left] = arr[i];
		arr[i] = pivot;
		return i;
	}
	
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	static void quickSort(int[] arr, int left, int right) {
		if(left >= right) return;
		int pi = partition(arr, left, right);
		if(pi + 1 == K) return;
		if(pi + 1 < K)
			quickSort(arr, pi+1, right);
		else
			quickSort(arr, left, pi-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		quickSort(arr, 0, N-1);
		bw.write(arr[K-1] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

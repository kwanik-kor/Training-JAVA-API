package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EurekaTheory10448 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		int arr[] = new int[46];
		for(int i = 1; i<=45; i++)
			arr[i] = i*(i + 1)/2;
		for(int t = 0; t<testCase; t++) {
			int K = Integer.parseInt(br.readLine());
			int idx = 0;
			for(int i = 1; i<=45; i++) {
				if(K < arr[i]) {
					idx = i;
					break;
				}
			}
			
			boolean isPossible = false;
			for(int i = 1; i<idx; i++) {
				for(int j = 1; j<idx; j++) {
					for(int k = 1; k<idx; k++){
						if(arr[i] + arr[j] + arr[k]  == K) {
							isPossible = true;
						}
					}
					if(isPossible) break;
				}
				if(isPossible) break;
			}
			bw.write((isPossible)? "1\n":"0\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

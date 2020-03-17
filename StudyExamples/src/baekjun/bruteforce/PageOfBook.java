package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PageOfBook {
	static int count[] = new int[10];
	
	static void calc(int n, int point) {
		while(n > 0) {
			count[n%10] += point;
			n/=10;
		}
	}
	
	static void solve(int end) {
		int point = 1;
		int start = 1;
		while(start <= end) {
			while(end % 10 != 9 && start<=end) {
				calc(end, point);
				end--;
			}
			
			if(start > end) break;
			
			while(start % 10 != 0 && start<=end) {
				calc(start, point);
				start++;
			}
			start /= 10;
			end /= 10;
			for(int i = 0; i<10; i++)
				count[i] += (end - start + 1)*point;
			point *= 10;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		solve(N);
		for(int i = 0; i<10; i++)
			bw.write(count[i] + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}

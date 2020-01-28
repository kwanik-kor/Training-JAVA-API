package baekjun.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Dice1041 {
	
	static class Dice{
		private int[] dice = new int[6];
		
		Dice(StringTokenizer st) {
			for(int i = 0; i<6; i++)
				dice[i] = Integer.parseInt(st.nextToken());
		}
		
		int onlyOne() {
			int sum = 0;
			int max = 0;
			for(int i = 0; i<6; i++) {
				sum += dice[i];
				max = Math.max(max, dice[i]);
			}
			return sum - max;
		}
		
		long minOne() {
			long min = 51L;
			for(int i = 0; i<6; i++)
				min = Math.min(min, dice[i]);
			return min;
		}
		
		long minTwo() {
			long min = 101L;
			for(int i = 0; i<6; i++) {
				for(int j = i+1; j<6; j++) {
					if(j != 5-i) {
						int sum = dice[i] + dice[j];
						min = Math.min(sum, min);
					}
				}
			}
			return min;
		}
		
		long minThree() {
			long min = 151L;
			long temp[] = {dice[0]+dice[1]+dice[2], dice[0]+dice[1]+dice[3], dice[0]+dice[2]+dice[4], dice[0]+dice[3]+dice[4], dice[1]+dice[2]+dice[5], dice[1]+dice[3]+dice[5], dice[2]+dice[4]+dice[5], dice[3]+dice[4]+dice[5]};
			for(int i = 0; i<8; i++)
				min = Math.min(temp[i], min);
			return min;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Dice dice = new Dice(st);
		if(N == 1)
			bw.write(dice.onlyOne() + "");
		else {
			long sum = dice.minOne()*(N-2)*(5*N - 6) + dice.minTwo()*4*(2*N - 3) + dice.minThree()*4;
			bw.write(sum + "");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

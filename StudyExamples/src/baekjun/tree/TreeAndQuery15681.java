package baekjun.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class TreeAndQuery15681 {
	static int N, R, Q;
	static int dp[], parent[];
	static LinkedList<Integer> list[];
	static StringTokenizer st;
	 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		dp = new int[N+1];
		list = new LinkedList[N+1];
		for(int i = 1; i<=N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		for(int i = 0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
	}
	
	static class Node{
		int parent;
		
	}
}

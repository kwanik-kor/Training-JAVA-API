package baekjun.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class StackSequence1874 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int num = 1;
		int arr[] = new int[N];
		boolean isPossible = true;
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<arr.length; i++){
			arr[i] = Integer.parseInt(br.readLine());
			if(isPossible) {
				if(num <= arr[i]) {
					while(num <= arr[i]) {
						stack.push(num++);
						sb.append("+\n");
					}
				}
				if(stack.isEmpty()) isPossible = false;
				else {
					while(stack.peek() >= arr[i]) {
						stack.pop();
						sb.append("-\n");
						if(stack.isEmpty()) break;
					}
				}
			}
		}
		if(isPossible) bw.write(sb.toString());
		else bw.write("NO");
		bw.flush();
		bw.close();
		br.close();
	}

}

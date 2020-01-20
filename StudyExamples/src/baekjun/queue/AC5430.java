package baekjun.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class AC5430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int t = 0; t<T; t++) {
			char func[] = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String str[] = br.readLine().replace("[", "").replace("]", "").split(",");
			dq.clear();
			for(int i = 0; i<n; i++)
				dq.add(Integer.parseInt(str[i]));
			
			int flag = 1;
			boolean chk = true;
			for(int i = 0; i<func.length; i++) {
				if(func[i] == 'R')
					flag *= -1;
				else {
					if(dq.size() == 0) {
						chk = false;
						break;
					}
					int a = (flag > 0)? dq.pollFirst() : dq.pollLast();
				}
			}
			if(chk) {
				if(flag > 0) {
					sb.append("[");
					int temp = dq.size();
					if(temp != 0) {
						for(int i = 0; i<temp-1; i++)
							sb.append(dq.poll()+",");
						sb.append(dq.poll() + "]\n");
					}else
						sb.append("]\n");
				}else {
					sb.append("[");
					int temp = dq.size();
					if(temp != 0) {
						for(int i = 0; i<temp-1; i++)
							sb.append(dq.pollLast()+",");
						sb.append(dq.pollLast() + "]\n");
					}else
						sb.append("]\n");
				}
			}else
				sb.append("error\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

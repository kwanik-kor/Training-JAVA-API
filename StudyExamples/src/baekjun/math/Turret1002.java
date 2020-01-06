package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Turret1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			String s = br.readLine();
			int x1 = Integer.parseInt(s.split(" ")[0]);
			int y1 = Integer.parseInt(s.split(" ")[1]);
			int r1 = Integer.parseInt(s.split(" ")[2]);
			int x2 = Integer.parseInt(s.split(" ")[3]);
			int y2 = Integer.parseInt(s.split(" ")[4]);
			int r2 = Integer.parseInt(s.split(" ")[5]);
			
			int xdis = (x1 > x2)? x1 - x2 : x2 - x1;
			int ydis = (y1 > y2)? y1 - y2 : y2 - y1;
			double dis = Math.sqrt(xdis*xdis + ydis*ydis);
			if(x1 == x2 && y1 == y2 && r1 == r2) // 두 원이 완전히 같다면
				bw.write(-1 + "\n");
			else if(dis == r1 + r2 || dis == Math.abs(r1 - r2)) // 교점이 하나인 경우
				bw.write(1 + "\n");
			else if(dis < r1 + r2 && dis > Math.abs(r1 - r2))
				bw.write(2 + "\n");
			else
				bw.write(0 + "\n");
			
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

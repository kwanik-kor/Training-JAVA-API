package baekjun.functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star10993 {
	static int N;
	static char star[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int height = 1;
		for(int i = 1; i<N; i++)
			height = height*2 + 1;
		int width = height *2 - 1;
		star = new char[height + 1][width + 1];
		for(int i = 0; i<height+1; i++) {
			for(int j = 0; j<width+1; j++){
				star[i][j] = ' ';
			}
		}
		drawStar(1, 1, height, width, N);
		printStar(height, width);
		br.close();
	}
	
	static void drawStar(int startH, int startW, int h, int w, int seq) {
		if(seq == 0) return;
		if(seq % 2 != 0) {
			int space = h;
			for(int i = startH; i<startH + h; i++) {
				for(int j = startW; j<startW + w; j++) {
					if(i == startH + h - 1 || j == startW + space - 1|| j == startW + w - space)
						star[i][j] = '*';
				}
				space--;
			}
		}else {
			int space = 1;
			for(int i = startH; i<startH + h; i++) {
				for(int j = startW; j<startW + w; j++) {
					if(i == startH || j == startW + space - 1|| j == startW + w - space)
						star[i][j] = '*';
				}
				space++;
			}
		}
		if(seq % 2 != 0)
			drawStar(startH + h/2, startW + h/2 + 1, (h-1)/2, h-2, seq-1);
		else
			drawStar(startH + 1, startW + h/2 + 1, (h-1)/2, h-2, seq-1);
	}
	
	static void printStar(int height, int width) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(N % 2 == 0) {
			for(int i = 1; i<=height; i++) {
				for(int j = 1; j<=width-i+1; j++)
					bw.write(star[i][j]);
				bw.write("\n");
			}
		}else {
			int temp = height -1;
			for(int i = 1; i<=height; i++) {
				for(int j = 1; j<=width - temp; j++)
					bw.write(star[i][j]);
				bw.write("\n");
				temp--;
			}
		}
		bw.flush();
		bw.close();
	}
}

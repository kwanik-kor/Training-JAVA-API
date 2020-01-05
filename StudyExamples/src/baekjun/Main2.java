package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] first = bf.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int x = Integer.parseInt(first[1]);
        String[] second = bf.readLine().split(" ");
        for(int i = 0; i < second.length; i++) {
        	if(Integer.parseInt(second[i]) < x) {
        		bw.write(second[i] + " ");
        	}
        }
        bw.flush();
        bw.close();
	}
}

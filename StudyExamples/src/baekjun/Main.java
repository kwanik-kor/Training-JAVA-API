package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//�ܰ躰�� Ǯ��� - for ��
public class Main {
	//Base Template
	/*import java.util.Scanner;
	
	public class Main {
		
	}*/
	
	//1. ������ ���
	/*public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		for(int i = 1; i <= 9; i++) {
			System.out.println(n + " * " + i + " = " + n*i);
		}
	}*/
	
	//2. A�� B�� �Է� ���� ����, A+B�� ����ϴ� ���α׷�
	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a+b);
		}
	}*/
	
	public static void main(String[] args) throws IOException{
		//3. 1���� n������ ��
		/*int n = new Scanner(System.in).nextInt();
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);*/
		
		//4. ���� A+B
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine());
		for(int i = 0; i < t; i++) {
			String[] str = bf.readLine().split(" ");
			bw.write(Integer.parseInt(str[0]) + Integer.parseInt(str[1]) + "\n");
		}
		bf.close();
		bw.flush();
		bw.close();
	}
}

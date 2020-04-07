package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class VariableNaming3613 {
	//Java ������ ��Ģ : ù �ܾ �ҹ���, ���� �ܾ���ʹ� ù ���ڸ� �빮��, ��� �ܾ�� �ٿ���
	//C++ ������ ��Ģ: ������ũ ���
	static final int JAVA = 0;
	static final int C = 1;
	static final int BOTH = 2;
	static final int ERROR = 3;
	
	static int whichType(String var) {
		//ù ���ڰ� �빮���̰ų� , ù���ڳ� ������ ���ڰ� '_' �̸� ����
		if((var.charAt(0) >= 'A' && var.charAt(0) <= 'Z') || var.charAt(0) == '_' || var.charAt(var.length() - 1) == '_') 
			return ERROR;
		int upper = 0;
		int bar = 0;
		for(int i = 0; i<var.length(); i++) {
			char c = var.charAt(i);
			if(c >= 'A' && c <= 'Z') upper++;
			if(c == '_') {
				bar++;
				if(var.charAt(i+1) == '_') return ERROR; //underbar�� 2�� �̻� ���ӵ� ���
			}
		}
		if(upper > 0 && bar > 0) return ERROR;
		if(upper > 0 && bar == 0) return JAVA;
		if(upper == 0 && bar > 0 ) return C;
		return BOTH;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String var = br.readLine();
		int type = whichType(var);
		if(type == ERROR) bw.write("Error!");
		else if(type == BOTH) bw.write(var);
		else if(type == JAVA) {
			StringBuffer sb = new StringBuffer(var.charAt(0)+"");
			for(int i = 1; i<var.length(); i++) {
				char c = var.charAt(i);
				if(c >= 'A' && c <= 'Z')
					sb.append("_" + (char)(c + 32));
				else sb.append(c);
			}
			bw.write(sb.toString());
		}else {
			String arr[] = var.split("_");
			StringBuffer sb = new StringBuffer(arr[0]);
			for(int i = 1; i<arr.length; i++) {
				sb.append((char)(arr[i].charAt(0) - 32));
				for(int j = 1; j<arr[i].length(); j++)
					sb.append(arr[i].charAt(j));
			}
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

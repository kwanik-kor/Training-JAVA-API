package baekjun;

import java.util.Scanner;

public class BasicallySpeaking4689_2 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		while(sc.hasNextLine()) {
			String[] str = sc.nextLine().trim().split("\\s+");
			int num = 0;
			int n = Integer.parseInt(str[1]);
			int m = Integer.parseInt(str[2]);
			char[] arr = str[0].toCharArray();
			for(int i = arr.length - 1; i>=0; i--) {
				int temp = (arr[i] >= 65)? (int)arr[i] - '0' - 7: (int)arr[i] - '0';
				num += temp*Math.pow(n, arr.length - 1 - i);
			}
			if(num == 0) {
				ans.append("0\n");
			}else {
				StringBuilder sb = new StringBuilder();
				while(num > 0) {
					if(num % m < 10)
						sb.insert(0, num%m);
					else
						sb.insert(0, (char)(num%m + 55));
					num /= m;
				}
				while(sb.length() < 7)
					sb.insert(0,' ');
				if(sb.length() > 7)
					ans.append("  ERROR\n");
				else {
					sb.append("\n");
					ans.append(sb);
				}
			}
			System.out.println(ans);
		}
		
		sc.close();
	}

}

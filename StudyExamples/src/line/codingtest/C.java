package line.codingtest;

import java.util.ArrayList;

public class C {
	static String road;
	static int ret;
	static ArrayList<Integer> zero = new ArrayList<Integer>();
	
	static void comb(int cnt, int n, ArrayList<Integer> list) {
		if(cnt == n) {
			int dp[] = new int[road.length()];
			int maxLen = 0;
			int len = 0;
			for(int i = 0; i<road.length(); i++) {
				if(road.charAt(i) == '1'){
					len++;
					maxLen = Math.max(len, maxLen);
				}
				else {
					boolean flag = false;
					for(Integer j : list) {
						if(zero.get(j) == i) {
							flag = true;
							break;
						}
					}
					if(flag) {
						len++;
						maxLen = Math.max(len, maxLen);
					}else
						len = 0;
				}
			}
			ret = Math.max(ret, maxLen);
			return;
		}
		int min = list.isEmpty()? 0 : list.get(list.size() - 1) + 1;
		for(int next = min; next < zero.size(); next++) {
			list.add(next);
			comb(cnt + 1, n, list);
			list.remove(list.size() - 1);
		}
	}
	
	
	public static void main(String[] args) {
		road = "111011110011111011111100011111";
		int n = 3;
		
		for(int i = 0; i<road.length(); i++) {
			if(road.charAt(i) == '0')
				zero.add(i);
		}
		int ans = 0;
		if(n >= zero.size())
			ans = road.length();
		else {
			comb(0, n, new ArrayList<Integer>());
			ans = ret;
		}
		System.out.println(ans);
	}

}

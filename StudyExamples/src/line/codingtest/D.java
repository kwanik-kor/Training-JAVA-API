package line.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeMap;

public class D {
	static TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	static boolean[] transaction_ID = new boolean[100000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] snapshots = {{"ACCOUNT1", "100"},
				  {"ACCOUNT2", "150"},
				  {"ACCOUNT10", "150"}};
		String[][] transactions = {{"1", "SAVE", "ACCOUNT2", "100"},
				  {"2", "WITHDRAW", "ACCOUNT1", "50"},
				  {"1", "SAVE", "ACCOUNT2", "100"},
				  {"4", "SAVE", "ACCOUNT3", "500"},
				  {"3", "WITHDRAW", "ACCOUNT2", "30"}};
		
		for(int i = 0; i<snapshots.length; i++) 
			map.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		
		for(int i = 0; i<transactions.length; i++) {
			int id = Integer.parseInt(transactions[i][0]);
			String type = transactions[i][1];
			String account = transactions[i][2];
			int val = Integer.parseInt(transactions[i][3]);
			if(!transaction_ID[id]) {
				transaction_ID[id] = true;
				if(type.equals("WITHDRAW")) {
					int newVal = map.get(account) - val;
					map.put(account, newVal);
				}else {
					if(map.containsKey(account)) {
						int newVal = map.get(account) + val;
						map.put(account, newVal);
					}else
						map.put(account, val);
				}
			}
		}
		Iterator<String> keys = map.keySet().iterator();
		String[][] answer = new String[map.size()][2];
		int idx = 0;
		while(keys.hasNext()) {
			String key = keys.next();
			answer[idx][0] = key;
			answer[idx][1] = String.valueOf(map.get(key));
			idx++;
		}
	}

}

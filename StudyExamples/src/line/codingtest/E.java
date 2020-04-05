package line.codingtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class E {
	static ArrayList<Doc> list = new ArrayList<Doc>();
	
	public static void main(String[] args) {
		String[][] dataSource = {{"doc1", "t1", "t2", "t3"},
			    {"doc2", "t0", "t2", "t3"},
			    {"doc3", "t1", "t6", "t7"},
			    {"doc4", "t1", "t2", "t4"},
			    {"doc5", "t6", "t100", "t8"}};
		String[] tags = {"t1", "t2", "t3"};
		
		for(int i = 0; i<dataSource.length; i++) {
			String docName = dataSource[i][0];
			int cnt = 0;
			for(int j = 1; j<dataSource[i].length; j++)
				for(int k = 0; k<tags.length; k++)
					if(dataSource[i][j].equals(tags[k]))
						cnt++;
			if(cnt != 0)
				list.add(new Doc(docName, cnt));
		}
		
		Collections.sort(list, new Comparator<Doc>() {
			@Override
			public int compare(Doc d1, Doc d2) {
				if(d2.tags - d1.tags == 0) {
					return d1.name.compareTo(d2.name);
				}
				return d2.tags - d1.tags;
			}
		});
		int size = (list.size() > 10)? 10 : list.size();
		String[] ans = new String[size];
		for(int i = 0; i<size; i++)
			ans[i] = list.get(i).name;
	}
	
	static class Doc{
		String name;
		int tags;
		public Doc(String name, int tags) {
			this.name = name;
			this.tags = tags;
		}
	}

}

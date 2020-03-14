import java.util.ArrayList;

public class ForStudyClass {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		recursiveSelect(7, list, 4);
	}

	static void recursiveSelect(int n, ArrayList<Integer> list, int toPick) {
		if(toPick == 0) {
			for(Integer i : list)
				System.out.print(i + " ");
			System.out.println();
			return;
		}
		int min = list.isEmpty()? 0 : list.get(list.size() - 1) + 1;
		for(int next = min; next < n; next++) {
			list.add(next);
			recursiveSelect(n, list, toPick-1);
			list.remove(list.size() - 1);
		}
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long N = Long.parseLong(br.readLine());
		Stack<Long> stack = new Stack<>();
		while(N > 0) {
			stack.push(N%2);
			N/=2;
		}
		while(!stack.isEmpty()) {
			bw.write(stack.pop() + "");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

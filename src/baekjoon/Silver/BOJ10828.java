package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
// 실버4
public class BOJ10828 {

	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		stack = new Stack<Integer>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String command = st.nextToken();

			int value = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

			execute(command, value);
		}
	}

	private static void execute(String command, int value) {
		switch (command) {
		case "push":
			stack.add(value);
			break;
		case "pop":
			if (stack.isEmpty()) {
				System.out.println(-1);
				break;
			}
			System.out.println(stack.pop());
			break;
		case "size":
			System.out.println(stack.size());
			break;
		case "empty":
			int result = stack.isEmpty() ? 1 : 0;
			System.out.println(result);
			break;
		case "top":
			int result2 = 0;
			result2 = stack.isEmpty() ? -1 : stack.peek();
			System.out.println(result2);
			break;
		}
	}

}

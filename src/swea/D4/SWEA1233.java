package com.day8;

//사칙연산 유효성 검사 D4
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 정점 노드가 연산자인 경우 반드시 자식노드가 있어야한다 
// - 숫자 + 숫자
// - 연산자 + 숫자
// - 연산자 + 연산자
// - 숫자 + 연산자 (X) 완전 이진 트리이기 때문에 숫자가 왼쪽에 오면 그 밑으로 자식이 없기때문에 
// 	  완전 이진트리를 충족 시킬 수 없다.

// 2. 정점 노드가 숫자면 자식이 있으면 안된다.
public class SWEA1233 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/tree.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine()); // 노드의 갯수
			char[] tree = new char[N + 1]; // 노드 인덱스를 1번부터 사용하기 때문에 (0번은 사용x)

			int index = 0;

			// 입력 : 1 + 2 3
			// 뒤 두개의 토큰(왼쪽자식, 오른쪽자식)은 완전 이진트리 성격을 이용해서 계산 가능하므로 따로 저장하지 않음.
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				index = Integer.parseInt(st.nextToken()); // 노드 번호 // 배열의 인덱스로 사용할 거임
				tree[index] = st.nextToken().charAt(0);
			}

			// N개의 노드에 대해서 조사
			int left, right;
			boolean result = true;
			for (int n = 1; n <= N; n++) {
				left = n * 2; // 왼쪽자식 번호
				right = n * 2 + 1; // 오른쪽자식 번호

				if (Character.isDigit(tree[n])) { // 숫자니? 숫자인 경우 -> 자식이 있으면 x
					if (left <= N) { // 노드의 개수보다 작은 경우 -> 자식이 있는 경우
						result = false;
					}
				} else { // 연산자인 경우 - 자식이 있어야함
					if (left <= N && right <= N) { // 자식이 있는데
						if (Character.isDigit(tree[left]) && !Character.isDigit(tree[right])) { // 숫자 + 연산자
							result = false;
						}
					} else { // 자식이 없는 경우
						result = false;
					}
				}

				if (!result) {
					break;
				}

			} // for문 끝

			System.out.println("#" + tc + " " + (result ? 1 : 0));
		}
	}

}

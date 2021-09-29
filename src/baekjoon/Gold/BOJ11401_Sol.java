import java.util.Scanner;
/* <페르마의 소정리>
	a, p 서로소, p는 소수 
	a^P-1 ≡ 1 (mod P) 이다. 그리고 모든 a에 대하여 
	a^P ≡ a (mod P) 이다. 
	a^P-2 ≡ 1 / a (mod P) 
* 
*/

// 골드 1 이항계수3
public class BOJ11401_Sol {

	static int N, K, M = 1_000_000_007;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		// nCk

		long l = nCr(N, K);
		System.out.println(l);

	}

	// nCr = n! / (n-r)! * r!
	private static long nCr(int n, int r) {

		long result = 1L;

		result = result * fact(n); // n!
		
		result %= M;

		result = result * power(fact(n - r), M - 2); // 1 / (n-r)!
		
		result %= M;
		
		result = result * power(fact(r), M - 2); // 1 / r!
		
		result %= M;

		return result;

	}

	private static long power(long x, int y) { // x^y

		long re = 1L;

		while (y > 0) {
			if (y % 2 == 1) {// 홀수면
				
				re *= x; // re = 2
				re %= M;
			}
			x *= x; // re에 곱해줄 중간 값 먼저 계산
			x %= M;
			
			y /= 2;
		}

		return re;
	}

	private static long fact(int n) {
		long re = 1L;

		for (int i = 1; i <= n; i++) {
			re *= i;
			re %= M;
		}

		return re;
	}

}

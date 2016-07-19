package ex;
/*
 *  A and B are integers within the range [0..2,000,000,000];
    K is an integer within the range [1..2,000,000,000];
    A ≤ B.

 * */
public class Divisible {
	public int divisible(int A, int B, int K) {
		
		int count = 0;
		for (int i = A; i <= B; i++) {
			if (i % K == 0) {
				count++;
//				System.out.println(i);
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Divisible sol = new Divisible();
		System.out.println(sol.divisible(3,	 100, 5));
	}

}

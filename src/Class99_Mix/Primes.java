package Class99_Mix;

import java.util.ArrayList;
import java.util.List;

public class Primes {
	public List<Integer> primes(int target) {
		List<Integer> rsl = new ArrayList<Integer>();
		if (target <= 0) {
			return rsl;
		}
		if (target >= 2) {
			rsl.add(2);
		}
		for (int i = 2; i <= target; i++) {
			boolean flag = false;
			for (Integer p : rsl) {
				if (i % p == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				rsl.add(i);
			}
		}
		// Write your solution here.
		return rsl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Primes sol = new Primes();
		System.out.println(sol.primes(17));
	}

}

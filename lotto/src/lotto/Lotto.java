package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	public static void main(String[] args) {
		List<Integer> lotto = new ArrayList<>();
		int lottoNumber = (int)(Math.random() * 46);
		lotto.add((int)(Math.random() * 45 + 1));
		lotto.add((int)(Math.random() * 45 + 1));
		lotto.add((int)(Math.random() * 45 + 1));
		lotto.add((int)(Math.random() * 45 + 1));
		lotto.add((int)(Math.random() * 45 + 1));
		lotto.add((int)(Math.random() * 45 + 1));
		
		int n = 0;
		n++;
		System.out.println(n + "회차 => "+ lotto);
		
		int[] lottoNumbers = new int[6];
		
	}

}

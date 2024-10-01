package lesson20241001;

public class NestlingExamples {

	public static void main(String[] args) {

		int trials = 10;
		int stake = 5;
		int goal = 100;
		int wins = 0;
		
		for (int t = 0; t < trials ; t++) {
			int cash = stake;
			while (cash > 0 && cash < goal) {
				if (Math.random() < 0.5) {
					cash++;
				} else {
					cash--;
				}
			}
			
			if (cash == goal) {
				wins++;
			}
		}

	}

}

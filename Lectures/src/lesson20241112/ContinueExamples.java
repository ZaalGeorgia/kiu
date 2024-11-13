package lesson20241112;

public class ContinueExamples {
	
	public static void main(String[] args) {
		
		
		int[][] m = {
				{0, -3, 1, 2},
				{1, 1, 2},
				{3, -5, 1, 0, -4},
		};
		
		int rowsWithZeroes = countRowsWithZeroes(m);
		
		System.out.println(rowsWithZeroes);
		
		int sumOfpositiveValues = sumPositiveValues(m);
		
		System.out.println(sumOfpositiveValues);
		
	}

	private static int sumPositiveValues(int[][] m) {
		int sum= 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] <= 0) continue;
				sum += m[i][j];
			}
		}
		return sum;
	}

	private static int countRowsWithZeroes(int[][] m) {
		int count = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 0) {
					count++;
					break;
				}
			}
		}
		return count;
	}

}














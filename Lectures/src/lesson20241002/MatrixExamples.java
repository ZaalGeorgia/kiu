package lesson20241002;

import java.util.Arrays;

public class MatrixExamples {
	
	public static void main(String[] args) {
		
		int[][] a = {
				{0,1,2},
				{3,4,5},
				{6,7,8},
		};
		
		System.out.println(a.length + "\n");
		
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[row].length; col++) {
				System.out.print(a[row][col] + ",");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int row = 0; row < a.length; row++) {
			System.out.println(Arrays.toString(a[row]));
		}
		
	}

}

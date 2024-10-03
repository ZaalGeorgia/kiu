package lesson20241003;

import java.util.Arrays;

public class MatrixShapes {
	
	public static void main(String[] args) {
		
		
		int[][] matrix = {
				{0},
				{0, 1},
				{0, 1, 2},
				{0, 1},
				{0},
		};
		
		for (int i = 0; i < matrix.length; i++) {
			
//			System.out.println(matrix[i]);
			System.out.println(Arrays.toString(matrix[i]));
			
//			for (int j = 0; j < matrix[i].length; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
		}
		
	}

}

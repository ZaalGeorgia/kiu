package lesson20241003;

import java.util.Arrays;

public class MatrixShapes2 {
	
	public static void main(String[] args) {
		
		int[][] matrix = new int[3][];
		
		System.out.println(matrix[0]);
		
		matrix[0] = new int[] {1,2,3};
		matrix[2] = new int[] {6,7,8};
		
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		
		
		int[] t;
		
		t = new int[] {30, 40, 50};
		
		int[] t2 = {1,2,3};
	}

}

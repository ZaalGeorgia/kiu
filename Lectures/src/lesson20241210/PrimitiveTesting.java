package lesson20241210;

import utils.Library;
import utils.Test;

public class PrimitiveTesting {
	
	public static void main(String[] args) {
		
		testSumIsCalculatedCorrectly();
		
		testSumShouldThrowNPE();
		
		testThrowsIAEForEmptyArray();
		
		
	}

	private static void testThrowsIAEForEmptyArray() {
		try {
			int sum = Library.sum(new int[] {});
		} catch (IllegalArgumentException iae) {
			System.out.println("Correct");
		} catch (Exception e) {
			// ignore
		}
		System.out.println("incorrect: should be IAE");
	}

	private static void testSumShouldThrowNPE() {
		try {
			int sum = Library.sum(null);
		} catch (NullPointerException npe) {
			System.out.println("Correct");
			return;
		} catch (Exception e) {
			// ignore
		}
		System.out.println("incorrect: should be NPE");
	}

	private static void testSumIsCalculatedCorrectly() {
		int sum = Library.sum(new int[] {1,2,3});
		
		System.out.println(Test.assertEquals(sum, 6)? "Correct" : "Incorrect");
	}

}

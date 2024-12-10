package lesson20241210;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzTest {

	@Test
	public void testUsage() {
		String result = FizzBuzz.play(1);
	}
	
	@Test
	public void testReturnsFizzFor3() throws Exception {
		assertEquals("Fizz", FizzBuzz.play(3));
		assertEquals("Fizz", FizzBuzz.play(6));
	}

	@Test
	public void testReturnsBuzzFor5() throws Exception {
		assertEquals("Buzz", FizzBuzz.play(5));
		assertEquals("Buzz", FizzBuzz.play(10));
	}
	
	@Test
	public void testReturnsFizzBuzzFor15() throws Exception {
		assertEquals("FizzBuzz", FizzBuzz.play(15));
		assertEquals("FizzBuzz", FizzBuzz.play(30));
	}
	
	@Test
	public void testDoesNotReturnFizzFor2() throws Exception {
		assertNotEquals("Fizz", FizzBuzz.play(2));
	}
	
	@Test
	public void testReturnsNumberAsString() throws Exception {
		assertEquals("2", FizzBuzz.play(2));
		assertEquals("4", FizzBuzz.play(4));
		
	}
	
}

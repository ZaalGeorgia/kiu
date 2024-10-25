package officehour20241024;

public class ArgumentsParsing {
	
	public static void main(String[] parameters) {
		
		System.out.println("Number of parameters: " + parameters.length);
		
		String firstParameter = parameters[0];
		
		System.out.println(firstParameter);
		
		int firstNumber = Integer.parseInt(firstParameter);
		
		System.out.println(firstNumber + 1);
		
	}

}

package lesson20241112;

public class ForEachLoops {
	
	public static void main(String[] args) {
		
		String[] cities = {"Tbilsi", "Kutaisi", "Batumi", "Gori"};
		
		for (String city : cities) {
			System.out.println(city.length());
		}
		
		for (int i = 0; i < cities.length; i++) {
			String city = cities[i];
			System.out.println(city.length());
		}
		
	}

}

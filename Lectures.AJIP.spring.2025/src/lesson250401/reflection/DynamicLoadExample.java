package lesson250401.reflection;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import utils.Utils;

public class DynamicLoadExample {
	
	public static void main(final String[] args) {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Engine engine = new Engine();
		executor.execute(engine);
		
		Utils.pause(2000);
		engine.setAd(() -> "hi there!");
		
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine()) {
				String className = scanner.nextLine();
				try {
					Class<?> someClass = Class.forName(className);
					System.out.println(someClass);
					boolean isAd = Ad.class.isAssignableFrom(someClass);
					if (isAd) {
						try {
							Ad someAd = (Ad) someClass.newInstance();
							engine.setAd(someAd);
						} catch (InstantiationException | IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}


class Engine implements Runnable {
	Ad currentAd;
	
	public void setAd(final Ad ad) {
		currentAd = ad;
	}

	@Override
	public void run() {
		while (true) {
			if (currentAd != null) { 
				System.out.println(currentAd.getDescription());
			}
			Utils.pause(3000);
		}
		
	}
	
}

interface Ad {
	String getDescription();
}

class NewAd implements Ad {

	@Override
	public String getDescription() {
		return "new ad";
	}
	
}

class OtherAd implements Ad {

	@Override
	public String getDescription() {
		return "completely new ad!";
	}
	
}










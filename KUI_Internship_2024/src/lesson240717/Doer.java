package lesson240717;

public interface Doer {

	void doItForMe();
	
	// factory method
	public static Doer someDoer() {
		double random = Math.random();
		if (random < 0.5) {
			return new B();
		} else {
			return new Doer() {

				@Override
				public void doItForMe() {
					System.out.println("I did it another way");
				}
				
			};
		}
	}

}
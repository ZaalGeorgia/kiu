package lesson250611.actors;

import utils.Utils;

public class ActorUsage {
	
	public static void main(String[] args) {
		
		Actor actor1 = new Actor();
		Actor actor2 = new Actor();
		
		
		actor1.accept(new Command(Command.MESSAGE, "hi there", actor2));
		
		
		Utils.pause(10000);
		
	}

}

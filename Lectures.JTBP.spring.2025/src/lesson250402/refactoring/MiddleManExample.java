package lesson250402.refactoring;

public class MiddleManExample {
	
	public static void main(String[] args) {
		
		// BAD
		MiddleMan mm = new MiddleMan();
		mm.doSomething();
		
		// GOOD
		RealWorker rw = new RealWorker();
		rw.doRealJob();
				
	}

}

class RealWorker {

	public void doRealJob() {
		System.out.println("Real Job");
	}
	
}


class MiddleMan {
	
	RealWorker rq = new RealWorker();
	
	void doSomething() {
		rq.doRealJob();
	}
}

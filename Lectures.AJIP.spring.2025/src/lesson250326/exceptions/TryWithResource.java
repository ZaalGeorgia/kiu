package lesson250326.exceptions;

public class TryWithResource {
	
	public static void main(final String[] args) {
		
//		Resource r = new Resource();
//		try {
//			r.use();
//		} finally {
//			r.close();
//		}
//
		try (Resource r = new Resource()) {
			r.use();
		}
		
	}

}


class Resource implements AutoCloseable {
	
	void use() {
		System.out.println("used");
		throw new RuntimeException();
	}
	
	
	@Override
	public void close() {
		System.out.println("closed");
	}
	
	
}

package lesson250331.refactoring;

public class DataClumps {

}


class DC {
	
	DCData data = new DCData();
	
	int z;
	
	void someCode() {
		System.out.println(data.plus());
	}

	void otherCode() {
		System.out.println(data.minus());
	}
	
}

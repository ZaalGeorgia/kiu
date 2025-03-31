package lesson250331.refactoring;

public class ReplaceSwitch {

}


class SwitchUse {
	static final int A = 0;
	static final int B = 1;
	static final int C = 2;
	static final int D = 3;
	
	int state = A;
	
	void doOne() {
		switch (state) {
		case A:
			break;
		case B:
			break;
		case C:
			break;

		default:
			break;
		}
	}
	
	void doTwo() {
		switch (state) {
		case A:
			break;
		case B:
			break;
		case C:
			break;
			
		default:
			break;
		}
		
	}
	
	void doThree() {
		switch (state) {
		case A:
			break;
		case B:
			break;
		case C:
			break;
			
		default:
			break;
		}
	}
	
	
	
	
}
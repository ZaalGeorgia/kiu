package officehour202411113.custom;

import officehour202411113.global.Global;

public class Custom {
	
	public static void main(String[] args) {

		System.out.println(Global.globalInt);
		
		Global.globalInt = 100;
		
		System.out.println(Global.globalInt);
		
	}

}

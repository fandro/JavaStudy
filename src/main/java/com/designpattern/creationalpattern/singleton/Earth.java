package com.designpattern.creationalpattern.singleton;

public class Earth {
	private static Earth earth = new Earth();
	private Earth(){
	}

	public static Earth getInstance(){
		return earth;
	}

	public static class Moon{
		private static Moon moon=null;
		private Moon(){}

		public static synchronized Moon getInstance(){
			if (moon==null) {
				moon = new Moon();
			}
			return moon;
		}
	}

}


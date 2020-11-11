package com.designpattern.creationalpattern.builder;


/**
 * @uml.dependency   supplier="creationalpattern.builder.AmericaBuilder"
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Director d = new Director();
		Builder builder = new AmericaBuilder();
		d.construct(builder);
		House house = builder.GetHouse();
		house.show();

	}

}

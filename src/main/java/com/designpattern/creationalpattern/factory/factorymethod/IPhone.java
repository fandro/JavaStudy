package com.designpattern.creationalpattern.factory.factorymethod;

/**
 * The Class IPhone.
 */
public class IPhone implements Phone {

	/* (non-Javadoc)
	 * @see creationalpattern.factory.simplefactory.Phone#call(java.lang.String)
	 */
	public void call() {
		System.out.println("call form IPhone!");
	}

}

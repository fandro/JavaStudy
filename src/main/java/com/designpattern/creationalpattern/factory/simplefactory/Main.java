package com.designpattern.creationalpattern.factory.simplefactory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Phone phone = SimpleFactory.producePhone('i');
		phone.call();
		Phone phone2 = SimpleFactory.producePhone('m');
		phone2.call();
	}
	 
}

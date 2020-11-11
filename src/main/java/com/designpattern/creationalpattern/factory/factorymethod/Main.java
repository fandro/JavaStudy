package com.designpattern.creationalpattern.factory.factorymethod;

/**
 * The Class ThreadMain.
 * @uml.dependency   supplier="creationalpattern.factory.factorymethod.Phone"
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		PhoneFactory phoneFactory;
		Phone phone;
		phoneFactory = new IphoneFactory();
		//phoneFactory = new XiaoMiFactory();
		phone= phoneFactory.produce();
		phone.call();
	}

}

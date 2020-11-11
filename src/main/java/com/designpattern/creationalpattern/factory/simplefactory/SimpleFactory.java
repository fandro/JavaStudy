package com.designpattern.creationalpattern.factory.simplefactory;

/**
 * A factory for creating Simple objects.
 */
public class SimpleFactory {

	/**
	 * Call phone.
	 *
	 * @param phoneName the phone name
	 * @return the creationalpattern.factory.simplefactory. phone
	 */
	public static Phone producePhone(char phoneName) {
		switch (phoneName) {
		case 'i':
			return new IPhone();
		case 'm':
			return new MotoME525();
		default:
			return  null;
		}
	}
	 
}

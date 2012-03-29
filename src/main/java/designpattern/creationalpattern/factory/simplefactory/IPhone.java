package designpattern.creationalpattern.factory.simplefactory;

/**
 * The Class IPhone.
 */
public class IPhone implements Phone {

	/* (non-Javadoc)
	 * @see creationalpattern.factory.simplefactory.Phone#call(java.lang.String)
	 */
	@Override
	public void call() {
		System.out.println("call form IPhone!");
	}

}

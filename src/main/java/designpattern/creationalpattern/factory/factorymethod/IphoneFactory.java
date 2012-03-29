package designpattern.creationalpattern.factory.factorymethod;


/**
 * @uml.dependency   supplier="creationalpattern.factory.factorymethod.IPhone"
 */
public class IphoneFactory implements PhoneFactory {

	public Phone produce() {
		// TODO Auto-generated method stub
		return new IPhone();
	}

}

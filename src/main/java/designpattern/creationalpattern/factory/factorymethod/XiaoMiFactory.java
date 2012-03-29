package designpattern.creationalpattern.factory.factorymethod;


/**
 * @uml.dependency   supplier="creationalpattern.factory.factorymethod.Phone"
 * @uml.dependency   supplier="creationalpattern.factory.factorymethod.XiaoMi"
 */
public class XiaoMiFactory implements PhoneFactory {

	@Override
	public Phone produce() {
		return new XiaoMi();
	}

}

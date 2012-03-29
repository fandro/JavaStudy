package designpattern.creationalpattern.factory.factorymethod;

/**
 * The Class Main.
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
		//使用Iphone打电话
		phoneFactory = new IphoneFactory();
		//修改为小米手机打电话
		//phoneFactory = new XiaoMiFactory();
		phone= phoneFactory.produce();
		phone.call();
		
		/**
		 * 从上面可以看出变化点是Factory的实现类(IphoneFactory和XiaoMiFactory),
		 * 如何新增MotoFactory,只需要替换IphoneFactory()或XiaoMiFactory(),其他都不需要变动
		 */
	}

}

package designpattern.creationalpattern.factory.factorymethod;

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
		//ʹ��Iphone��绰
		phoneFactory = new IphoneFactory();
		//�޸�ΪС���ֻ���绰
		//phoneFactory = new XiaoMiFactory();
		phone= phoneFactory.produce();
		phone.call();
		
		/**
		 * ��������Կ����仯����Factory��ʵ����(IphoneFactory��XiaoMiFactory),
		 * �������MotoFactory,ֻ��Ҫ�滻IphoneFactory()��XiaoMiFactory(),����������Ҫ�䶯
		 */
	}

}

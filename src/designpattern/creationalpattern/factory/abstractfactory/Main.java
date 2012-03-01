package designpattern.creationalpattern.factory.abstractfactory;


public class Main {

	/**
	 * 需要验证是否能运行
	 * @param args
	 */
	public static void main(String[] args) {
		PCFactory f = new DellFactory();//戴尔工厂生产完戴尔电脑
		Supplier s = new Supplier(f);//电脑发货给pc大卖场
		s.isEnableRun();//验证能否运行
	}

}

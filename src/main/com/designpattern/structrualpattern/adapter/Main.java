package designpattern.structrualpattern.adapter;


public class Main {

	public static void main(String[] args) {
		Target target = new Adapter(new Adaptee());
		target.targetMethod();
	}
	
}

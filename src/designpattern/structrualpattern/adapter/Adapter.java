package designpattern.structrualpattern.adapter;


public class Adapter implements Target {
	private Adaptee adaptee;
	
	public Adapter (Adaptee adaptee){
		this.adaptee=adaptee;
	}
	
	@Override
	public void targetMethod() {
		adaptee.adapteeMethod();
		System.out.println("Adapter Method!!");
	}

}

package designpattern.behavioralpattern.templatemethod;


public abstract class Bag {
	
	protected void makeBag() {
		System.out.println("�����������ģ��");
	}
	
	protected abstract void addColor();
	
	protected void sale() {
	   System.out.println("�������۴�����ɫ�����");
	}
	
	public final void show() {
	   this.makeBag();
	   this.addColor();
	   this.sale();
	}
}

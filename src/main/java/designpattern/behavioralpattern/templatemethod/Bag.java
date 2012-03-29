package designpattern.behavioralpattern.templatemethod;


public abstract class Bag {
	
	protected void makeBag() {
		System.out.println("制作好了书包模板");
	}
	
	protected abstract void addColor();
	
	protected void sale() {
	   System.out.println("正在销售此种颜色的书包");
	}
	
	public final void show() {
	   this.makeBag();
	   this.addColor();
	   this.sale();
	}
}

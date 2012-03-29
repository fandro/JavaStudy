package designpattern.structrualpattern.bridge;


public class Men implements Person {
	private Clothing clothing;
	
	public Men(Clothing clothing) {
		this.clothing = clothing;
	}
	
	public void doDress() {
		System.out.print("men ");
		clothing.dress();
	}

}

package designpattern.structrualpattern.bridge;


public class Women implements Person { 
	private Clothing clothing;
	
	public Women(Clothing clothing) {
		this.clothing = clothing;
	}
	
	@Override
	public void doDress() {
		String women = "";
		System.out.print("women "+women);
		clothing.dress();
	}

}

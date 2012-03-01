package designpattern.behavioralpattern.templatemethod;


public class RedColorBag extends Bag {

	@Override
	protected void addColor() {
		System.out.println("加工成红色");
	}

}

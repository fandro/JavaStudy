package designpattern.behavioralpattern.templatemethod;


public class BlueColorBag extends Bag{

	@Override
	protected void addColor() {
		System.out.println("加工成蓝色");
	}

}

package com.designpattern.behavioralpattern.templatemethod;


public class RedColorBag extends Bag {

	@Override
	protected void addColor() {
		System.out.println("color");
	}

}

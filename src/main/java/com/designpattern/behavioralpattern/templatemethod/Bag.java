package com.designpattern.behavioralpattern.templatemethod;


public abstract class Bag {
	
	protected void makeBag() {
		System.out.println("??????????????");
	}
	
	protected abstract void addColor();
	
	protected void sale() {
	   System.out.println("???????????????????");
	}
	
	public final void show() {
	   this.makeBag();
	   this.addColor();
	   this.sale();
	}
}

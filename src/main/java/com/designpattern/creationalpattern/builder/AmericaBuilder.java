package com.designpattern.creationalpattern.builder;


public class AmericaBuilder extends Builder {

	   private House englandHouse=new House();
	    public void BuildDoor() {
	        englandHouse.add("EnglandDoor");
	    }
	    public void BuildWall() {
	        englandHouse.add("EnglandWall");
	    }
	    public void BuildWindows() {
	        englandHouse.add("EnglandWindows");
	    }
	    public void BuildHouseCeiling() {
	        englandHouse.add("EnglandHouserCeiling");
	    }
	    public House GetHouse() {
	        return englandHouse;
	    }

}

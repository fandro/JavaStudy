package designpattern.creationalpattern.builder;


public class Director {
	
    public void construct(Builder builder){
        builder.BuildDoor();
        builder.BuildWall();
        builder.BuildWindows();
        builder.BuildHouseCeiling();
    }
}

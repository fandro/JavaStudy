package designpattern.creationalpattern.builder;

import java.util.ArrayList;


public class House {

	/**
	 * @uml.property  name="parts"
	 */
	private ArrayList<String> parts=new ArrayList<String>();

	/**
	 * Getter of the property <tt>parts</tt>
	 * @return  Returns the parts.
	 * @uml.property  name="parts"
	 */
	public ArrayList getParts() {
		return parts;
	}

	/**
	 * Setter of the property <tt>parts</tt>
	 * @param parts  The parts to set.
	 * @uml.property  name="parts"
	 */
	public void setParts(ArrayList parts) {
		this.parts = parts;
	}

	
	/**
	 * Ìí¼ÓÃèÊö.
	 *
	 * @param str the str
	 */
	public void add(String str){
		parts.add(str);
	}

			
	/**
	 * ÏÔÊ¾ÃèÊö.
	 */
	public void show(){
		for(String part:parts)
        {
            System.out.println(part+"\t");
        }
        System.out.println("\n");
	}

}

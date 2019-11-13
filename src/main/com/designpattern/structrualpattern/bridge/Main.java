package designpattern.structrualpattern.bridge;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Clothing tshirt = new TShirt();//T恤
		Clothing jacket = new Jacket();//夹克
		Clothing skirt = new Skirt();//裙子
		
		Person men = new Men(tshirt);//--男人穿T恤
		men.doDress();
		men = new Men(jacket);//--男人穿夹克
		men.doDress();
		men = new Men(skirt);//--男人穿裙子:)
		men.doDress();		
		
		Person women = new Women(tshirt);//--女人穿T恤
		women.doDress();
		women = new Women(jacket);//--女人穿夹克
		women.doDress();
		women = new Women(skirt);//--女人穿裙子
		women.doDress();			
	}

}

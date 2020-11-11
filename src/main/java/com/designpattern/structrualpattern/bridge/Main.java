package com.designpattern.structrualpattern.bridge;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Clothing tshirt = new TShirt();//T��
		Clothing jacket = new Jacket();//�п�
		Clothing skirt = new Skirt();//ȹ��
		
		Person men = new Men(tshirt);//--���˴�T��
		men.doDress();
		men = new Men(jacket);//--���˴��п�
		men.doDress();
		men = new Men(skirt);//--���˴�ȹ��:)
		men.doDress();		
		
		Person women = new Women(tshirt);//--Ů�˴�T��
		women.doDress();
		women = new Women(jacket);//--Ů�˴��п�
		women.doDress();
		women = new Women(skirt);//--Ů�˴�ȹ��
		women.doDress();			
	}

}

package com.designpattern.creationalpattern.factory.abstractfactory;


public class Main {

	/**
	 * ��Ҫ��֤�Ƿ�������
	 * @param args
	 */
	public static void main(String[] args) {
		PCFactory f = new DellFactory();//���������������������
		Supplier s = new Supplier(f);//���Է�����pc������
		s.isEnableRun();//��֤�ܷ�����
	}

}

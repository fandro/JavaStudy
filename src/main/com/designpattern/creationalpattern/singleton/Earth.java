package designpattern.creationalpattern.singleton;

public class Earth {
	private static Earth earth = new Earth();//������ʱ����ʵ����
	private Earth(){
	}
	
	public static Earth getInstance(){
		return earth;
	}

	public static class Moon{
		private static Moon moon=null;
		private Moon(){}
		
		public static synchronized Moon getInstance(){
			if (moon==null) {
				moon = new Moon();//����getInstance����ʱ����ʵ��������ʱ����ڶ��߳�ͬʱ���������⣬Ҳ����ͬ�����⣬��Ҫ���ͬ������
			}
			return moon;
		}
	}

}


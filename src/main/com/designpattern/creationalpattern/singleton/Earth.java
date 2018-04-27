package designpattern.creationalpattern.singleton;

public class Earth {
	private static Earth earth = new Earth();//载入类时进行实例化
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
				moon = new Moon();//调用getInstance方法时进行实例化，此时会存在多线程同时操作的问题，也就是同步问题，需要解决同步问题
			}
			return moon;
		}
	}

}


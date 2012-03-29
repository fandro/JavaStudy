package designpattern.creationalpattern.factory.abstractfactory;

/**
 * Ö÷°å The Interface MotherBoard.
 */
public interface MotherBoard {
		
		/**
		 * @return 
		 */
		public abstract boolean startRun(CPU cpu, RAM ram, HardDisk hd, Monitor monitor);
		

}

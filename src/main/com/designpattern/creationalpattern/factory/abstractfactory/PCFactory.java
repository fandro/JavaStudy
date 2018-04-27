package designpattern.creationalpattern.factory.abstractfactory;

public abstract class PCFactory {

		/**
		 */
		public abstract CPU assembleCPU();

		/**
		 */
		public abstract RAM assembleRAM();
				
		/**
		 */
		public abstract HardDisk assembleHardDisk();
					
		/**
		 * @return TODO
		 */
		public abstract Monitor assembleMonitor();

		/**
		 */
		public abstract MotherBoard assembleMohterBoard();

}

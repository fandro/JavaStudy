package designpattern.creationalpattern.factory.abstractfactory;


/**
 * pc´óÂô³¡  The Class Supplier.
 */
public class Supplier {

	/** The cpu. */
	private CPU cpu;
	
	/** The ram. */
	private RAM ram;
	
	/** The hd. */
	private HardDisk hd;
	
	/** The monitor. */
	private Monitor monitor;
	
	/** The mb. */
	private MotherBoard mb;

	/**
	 * Instantiates a new supplier.
	 */
	public Supplier() {
		
	}
	
	/**
	 * Instantiates a new supplier.
	 *
	 * @param factory the factory
	 */
	public Supplier(PCFactory factory) {
		cpu = factory.assembleCPU();
		ram = factory.assembleRAM() ;
		hd = factory.assembleHardDisk();
		monitor= factory.assembleMonitor();
		mb= factory.assembleMohterBoard();
	}
	
	public boolean isEnableRun(){
		return mb.startRun(cpu, ram, hd, monitor);
	}
	
}

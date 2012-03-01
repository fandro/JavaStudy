package designpattern.creationalpattern.factory.abstractfactory;


/**
 * ´÷¶û¹¤³§
 * @uml.dependency   supplier="creationalpattern.factory.abstractfactory.PCFactory"
 */
class DellFactory extends PCFactory {

	@Override
	public CPU assembleCPU() {
		return new IntelCPU();
	}

	@Override
	public RAM assembleRAM() {
		return new Hynix();
	}

	@Override
	public HardDisk assembleHardDisk() {
		return new Seagate();
	}

	@Override
	public Monitor assembleMonitor() {
		return new AOC();
	}

	@Override
	public MotherBoard assembleMohterBoard() {
		return new Intel();
	}

}

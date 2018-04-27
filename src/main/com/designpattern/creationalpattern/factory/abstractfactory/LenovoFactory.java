package designpattern.creationalpattern.factory.abstractfactory;


/**
 * 联想工厂 A factory for creating Lenovo objects.
 */
class LenovoFactory extends PCFactory {

	/* (non-Javadoc)
	 * @see creationalpattern.factory.abstractfactory.PCFactory#assembleCPU()
	 */
	@Override
	public CPU assembleCPU() {
		return new AMDCPU();
	}

	/* (non-Javadoc)
	 * @see creationalpattern.factory.abstractfactory.PCFactory#assembleRAM()
	 */
	@Override
	public RAM assembleRAM() {
		return new Samsung();
	}

	/* (non-Javadoc)
	 * @see creationalpattern.factory.abstractfactory.PCFactory#assembleHardDisk()
	 */
	@Override
	public HardDisk assembleHardDisk() {
		return new WD();
	}

	/* (non-Javadoc)
	 * @see creationalpattern.factory.abstractfactory.PCFactory#assembleMonitor()
	 */
	@Override
	public Monitor assembleMonitor() {
		return new LG();
	}

	/* (non-Javadoc)
	 * @see creationalpattern.factory.abstractfactory.PCFactory#assembleMohterBoard()
	 */
	@Override
	public MotherBoard assembleMohterBoard() {
		return new ASUS();
	}

}

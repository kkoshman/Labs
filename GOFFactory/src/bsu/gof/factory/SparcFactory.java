package bsu.gof.factory;

public class SparcFactory extends ComputerFactory {

	public Computer createComputer() {
		return new SparcComputer();
	}

	public Motheboard createMotheboard() {
		return new SparcMotheboard();
	}

	public Rom createROM() {
		return new SparcRom();
	}

	public Cpu createCPU() {
		return new SparcCpu();
	}

}

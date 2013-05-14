package bsu.gof.factory;

public class PCFactory extends ComputerFactory {
	public Computer createComputer() {
		return new PCComputer();
	}

	public Motheboard createMotheboard() {
		return new PCMotheboard();
	}

	public Rom createROM() {
		return new PCRom();
	}

	public Cpu createCPU() {
		return new PCCpu();
	}
}

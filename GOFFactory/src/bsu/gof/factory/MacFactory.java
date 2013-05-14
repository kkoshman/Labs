package bsu.gof.factory;

public class MacFactory extends ComputerFactory {
	public Computer createComputer() {
		return new MacComputer();
	}

	public Motheboard createMotheboard() {
		return new MacMotheboard();
	}

	public Rom createROM() {
		return new MacRom();
	}

	public Cpu createCPU() {
		return new MacCpu();
	}
}

package bsu.gof.factory;

public abstract class ComputerFactory {
	public abstract Computer createComputer();

	public abstract Motheboard createMotheboard();

	public abstract Rom createROM();

	public abstract Cpu createCPU();

	public static ComputerFactory getInstance(ComputerType ctype) {
		ComputerFactory cf = null;
		switch (ctype) {
		case MAC: {
			cf = new MacFactory();
			break;
		}
		case PC: {
			cf = new PCFactory();
			break;
		}
		case SPARC: {
			cf = new SparcFactory();
			break;
		}
		}
		return cf;
	}

}

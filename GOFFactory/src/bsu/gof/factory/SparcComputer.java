package bsu.gof.factory;

public class SparcComputer extends Computer {
	@Override
	public ComputerType getType() {
		return ComputerType.SPARC;
	}
}

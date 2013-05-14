package bsu.gof.factory;

public class PCComputer extends Computer {

	@Override
	public ComputerType getType() {
		return ComputerType.PC;
	}
}
package bsu.gof.factory;

public class MacComputer extends Computer {

	@Override
	public ComputerType getType() {
		return ComputerType.MAC;
	}
}
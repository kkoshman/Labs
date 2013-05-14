package bsu.gof.factory;

public abstract class Computer {
	private Motheboard motheboard;
	private Rom rom;
	private Cpu cpu;

	public Motheboard getMotheboard() {
		return motheboard;
	}

	public void setMotheboard(Motheboard motheboard) {
		this.motheboard = motheboard;
	}

	public Rom getRom() {
		return rom;
	}

	public void setRom(Rom rom) {
		this.rom = rom;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public abstract ComputerType getType();
}

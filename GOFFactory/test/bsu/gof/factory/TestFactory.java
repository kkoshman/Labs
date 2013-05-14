package bsu.gof.factory;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestFactory {

	@Test
	public void testMacComputer() {
		ComputerFactory factory = ComputerFactory.getInstance(ComputerType.MAC);
		Computer comp = factory.createComputer();
		comp.setCpu(factory.createCPU());
		comp.setMotheboard(factory.createMotheboard());
		comp.setRom(factory.createROM());

		assertTrue(comp.getType() == ComputerType.MAC);

	}

	@Test
	public void testPCComputer() {
		ComputerFactory factory = ComputerFactory.getInstance(ComputerType.PC);
		Computer comp = factory.createComputer();
		comp.setCpu(factory.createCPU());
		comp.setMotheboard(factory.createMotheboard());
		comp.setRom(factory.createROM());

		assertTrue(comp.getType() == ComputerType.PC);

	}
	
	@Test
	public void testSparcComputer() {
		ComputerFactory factory = ComputerFactory.getInstance(ComputerType.SPARC);
		Computer comp = factory.createComputer();
		comp.setCpu(factory.createCPU());
		comp.setMotheboard(factory.createMotheboard());
		comp.setRom(factory.createROM());

		assertTrue(comp.getType() == ComputerType.SPARC);

	}
	
	@Test
	public void testNewFabric() {
		ComputerType type = ComputerType.SPARC;
		NewComputerFactory factory = new NewComputerFactory();
		Computer comp = factory.createComputer(type);
		assertTrue(comp != null);
		assertTrue(comp.getType() == type);
		Cpu cpu = factory.createCPU(type);
		assertTrue(cpu != null);
		comp.setCpu(cpu);
		Motheboard motheboard = factory.createMotheboard(type);
		assertTrue(motheboard != null);
		comp.setMotheboard(motheboard);
		Rom rom = factory.createROM(type);
		assertTrue(rom != null);
		comp.setRom(rom);
	}

}
package bsu.gof.factory;

public class NewComputerFactory {
	public static final String PC_COMP = "bsu.gof.factory.PC";
	public static final String MAC_COMP = "bsu.gof.factory.Mac";
	public static final String SPARC_COMP = "bsu.gof.factory.Sparc";
	
	public static final String COMPUTER_DEV = "Computer"; 
	public static final String MOTHERBOARD_DEV = "Motheboard"; 
	public static final String ROM_DEV = "Rom"; 
	public static final String CPU_DEV = "Cpu"; 
	
	public Computer createComputer(ComputerType pType) {
		return (Computer) createDevice(pType, COMPUTER_DEV);
	}

	public Motheboard createMotheboard(ComputerType pType) {
		return (Motheboard) createDevice(pType, MOTHERBOARD_DEV);
	}

	public Rom createROM(ComputerType pType) {
		return (Rom) createDevice(pType, ROM_DEV);
	}

	public Cpu createCPU(ComputerType pType) {
		return (Cpu) createDevice(pType, CPU_DEV);
	}
	
	protected Object createDevice(ComputerType pType, String pDevice) {
		Object device = null;
		String compType = getCompTypePrefix(pType);
		try {
			device = Class.forName(compType + pDevice).newInstance();
		} catch (InstantiationException e) {
			 e.printStackTrace();
		} catch (IllegalAccessException e) {
			 e.printStackTrace();
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		}
		return device;
	}
	
	protected String  getCompTypePrefix(ComputerType pType) {
		String prefix = "";
		switch (pType) {
		case MAC: {
			prefix = MAC_COMP;
			break;
		}
		case PC: {
			prefix = PC_COMP;
			break;
		}
		case SPARC: {
			prefix = SPARC_COMP;
			break;
		}
		}
		return prefix;
	}
}

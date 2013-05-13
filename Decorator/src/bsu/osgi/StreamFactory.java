package bsu.osgi;

import java.util.HashMap;
import java.util.Map;

public class StreamFactory {

	protected static Map<String, Class<?>> streamClasses = null;
	protected static Map<String, Class<?>> decoratorClasses = null;
	static {
		streamClasses = new HashMap<String, Class<?>>();
		decoratorClasses = new HashMap<String, Class<?>>();
		try {
			streamClasses.put("FileStream", Class.forName("bsu.osgi.impl.FileStream"));
			
			decoratorClasses.put("ASCII7Stream", Class.forName("bsu.osgi.impl.ASCII7Stream"));
			decoratorClasses.put("CompressingStream", Class.forName("bsu.osgi.impl.CompressingStream"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static IAbstractStream getStream (String pName) {
		IAbstractStream abstractStream = null;
		Class<?> stClass = streamClasses.get(pName);
		if (stClass != null) {
			try {
				abstractStream = (IAbstractStream) stClass.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return abstractStream;
	}
	
	public static IAbstractStream getStream (String pBaseStreamName, String[] pDecorators) {
		IAbstractStream abstractStream = null;
		abstractStream = getStream(pBaseStreamName);
		if (abstractStream != null && pDecorators != null) {
			for (String decoratorName : pDecorators) {
				abstractStream = wrapStream(abstractStream, decoratorName);
			}
		}
		return abstractStream;
	}
	
	protected static IAbstractStream wrapStream(IAbstractStream pStream, String pDecoratorName) {
		IAbstractStream resultStream = pStream;
		DecoratorStream dStream = null;
		if (pDecoratorName != null && pStream != null) {
			Class<?> decorClass = decoratorClasses.get(pDecoratorName);
			if (decorClass != null) {
				try {
					dStream = (DecoratorStream) decorClass.newInstance();
					dStream.setAbstractStream(pStream);
					resultStream = dStream;
				} catch (InstantiationException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return resultStream;
	}
	/*public static IAbstractStream getAbstractStream(String pName) {
		IAbstractStream result = null;
		if ("FileStream".equals(pName)) {
			result = new FileStream();
		}
		return result;
	}

	public static IAbstractStream getAbstractStream(String pName, IAbstractStream oDecorator) {
		IAbstractStream result = null;

		if ("ASCII7Stream".equals(pName)) {
			result = new ASCII7Stream(oDecorator);
		} else {
		result = getAbstractStream(pName);
		}
		return result;
	}
	
	public static IAbstractStream getAvstractStream(String [] pNames) {
		IAbstractStream result = null;
		if (pNames != null && pNames.length > 0) {
			for (int i = 0; i < pNames.length; i++) {
				result = getAbstractStream(pNames[i], result);
			}
		}
		return result;
	}*/
	
}

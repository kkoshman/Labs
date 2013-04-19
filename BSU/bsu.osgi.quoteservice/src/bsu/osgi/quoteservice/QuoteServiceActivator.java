package bsu.osgi.quoteservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import bsu.osgi.quote.IQuoteService;

public class QuoteServiceActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
 	public void start(BundleContext context) throws Exception {
		IQuoteService service = new QuoteService();		
		context.registerService(IQuoteService.class.getName(),service, null);
		System.out.println("IQuoteService is registered");	
 	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		QuoteServiceActivator.context = null;
	}

}

package bsu.webapp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import bsu.webapp.util.GlobalApplication;

public class MyFilterChain implements FilterChain {
	protected List<Filter> mFilters;
	protected Iterator<Filter> mIterator;
	
	public MyFilterChain() {
		mFilters = new ArrayList<Filter>();
	}
	
	public MyFilterChain(List<Filter> pFilters) {
		this();
		mFilters.addAll(pFilters);
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1) throws IOException,
			ServletException {
		if (mIterator == null) {
			GlobalApplication.getInstance().getLogger().logMessage("Begin iteration", this);
			mIterator = mFilters.iterator();
		}
		if (mIterator.hasNext()) {
			Filter filter = mIterator.next();
			GlobalApplication.getInstance().getLogger().logMessage("Next filter " + filter.toString(), this);
			filter.doFilter(arg0, arg1, this);
		} else {
			GlobalApplication.getInstance().getLogger().logMessage("End iteration", this);
			mIterator = null;
		}

	}

}

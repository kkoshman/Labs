package bsu.webapp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterManager {
	public void executeFilterChain(HttpServletRequest pRequest, HttpServletResponse pResponse) throws IOException, ServletException {
		List<Filter> filters = new ArrayList<Filter>();
		filters.add(new MyAccessFilter());
		filters.add(new MyAthorizationFilter());
		FilterChain filterChain = new MyFilterChain(filters);
		filterChain.doFilter(pRequest, pResponse);
	}
}

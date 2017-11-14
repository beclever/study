package com.showshine.study.designpattern.filterpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2017-11-14 11:18
 * 
 */
public class FilterChain {

	private List<Filter> filters = new ArrayList<>();
	private Target target;

	public void addFilter(Filter filter) {
		filters.add(filter);
	}

	public void execute(String request) {
		for (Filter filter : filters) {
			filter.execute(request);
		}
		target.execute(request);
	}

	public void setTarget(Target target) {
		this.target = target;
	}

}

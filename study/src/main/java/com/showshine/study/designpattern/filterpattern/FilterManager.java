package com.showshine.study.designpattern.filterpattern;
/**
 * 过滤管理器
 *
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2017-11-14 11:20
 * 
 */
public class FilterManager {

	private FilterChain filterChain;
	
	public FilterManager(Target target) {
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}
	
	public void setFilter(Filter filter) {
		filterChain.addFilter(filter);
	}
	
	public void filterRequest(String request){
		filterChain.execute(request);
	}
}

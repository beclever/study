package com.showshine.study.designpattern.filterpattern;

/**
 * 演示拦截过滤器设计模式
 *
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2017-11-14 11:31
 * 
 */
public class FilterPatternDemo {

	public static void main(String[] args) {

		FilterManager filterManager = new FilterManager(new Target());
		filterManager.setFilter(new AuthFilter());
		filterManager.setFilter(new DebugFilter());

		Client client = new Client();
		client.setFilterManager(filterManager);
		client.sendRequest("HOME");
	}

}

package com.showshine.study.designpattern.filterpattern;

/**
 * 
 *
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2017-11-14 11:16
 * 
 */
public class DebugFilter implements Filter {

	@Override
	public void execute(String request) {

		System.out.println("debug filter execute:" + request);
	}

}

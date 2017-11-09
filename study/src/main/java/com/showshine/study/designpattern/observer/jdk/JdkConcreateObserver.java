package com.showshine.study.designpattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * jdk观察者模式：一个具体观察者
 * 
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @version 2017-11-09 14:18
 * 
 */
public class JdkConcreateObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("receives information: " + arg == null ? "": arg);
	}

}

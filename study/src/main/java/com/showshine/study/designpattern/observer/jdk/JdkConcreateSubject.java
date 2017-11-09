package com.showshine.study.designpattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * jdk观察者模式：一个被观察的主题
 * 
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @version 2017-11-09 14:14
 */
public class JdkConcreateSubject extends Observable {

	public void registerObserver(Observer observer) {
		addObserver(observer);
	}

	public void removeObserver(Observer observer) {
		deleteObserver(observer);
		//System.out.println("告诉观察者我不需要被通知了");
	}

	public void setChanged() {
		super.setChanged();
	}

	public void notifyAllObserver() {
		System.out.println("开始通知");
		notifyObservers();
		System.out.println("所有的都已通知！");
	}

}

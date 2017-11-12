package com.showshine.study.designpattern.templatepattern;

/**
 * 模板模式。 创建一个抽象类，它的模板方法被设置为 final
 * 
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2017-11-12 13:31
 */
public abstract class Game {
	
	abstract void initialize();

	abstract void startPlay();

	abstract void endPlay();

	// 模板
	public final void play() {

		// 初始化游戏
		initialize();

		// 开始游戏
		startPlay();

		// 结束游戏
		endPlay();
	}
}
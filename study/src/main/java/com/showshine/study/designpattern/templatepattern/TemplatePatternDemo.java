package com.showshine.study.designpattern.templatepattern;

/**
 * 使用 Game 的模板方法 play() 来演示游戏的定义方式
 * 
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2017-11-12 13:34
 */
public class TemplatePatternDemo {
	public static void main(String[] args) {

		Game game = new Cricket();
		game.play();
		System.out.println();
		game = new Football();
		game.play();
	}
}
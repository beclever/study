package com.showshine.study.designpattern.facadepattern;
/**
 * 创建一个外观类
 *
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2017-11-14 13:49
 * 
 */
public class ShapeMaker {

	private Circle circle;
	private Rectangle rectangle;
	private Square square;
	
	public ShapeMaker() {
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}
	
	public void drawCircle() {
		circle.draw();
	}
	
	public void drawRectangle() {
		rectangle.draw();
	}
	
	public void drawSquare() {
		square.draw();
	}
}

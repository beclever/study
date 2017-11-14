package com.showshine.study.designpattern.facadepattern;
/**
 * 使用外观类画出各种情况
 * 
 * @author showshine.wangsh (beclever@126.com)
 * 
 * @since 1.0
 * @version 2017-11-14 13:52
 */
public class FacadePatternDemo {
	
   public static void main(String[] args) {
      ShapeMaker shapeMaker = new ShapeMaker();

      shapeMaker.drawCircle();
      shapeMaker.drawRectangle();
      shapeMaker.drawSquare();        
   }
}
package com.showshine.study.proxy.dynamic;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

/**
 * 客户端。使用代理类和主题接口完成一些工作
 * 
 * @author showshine
 * @since 1.0
 * @version 2017年11月9日
 */
public class DynamicProxy {
	public static void main(String args[]) {
		RealSubject real = new RealSubject();
		Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
				new Class[] { Subject.class }, new ProxyHandler(real));

		proxySubject.doSomething();

		// write proxySubject class binary data to file
		createProxyClassFile();
	}

	public static void createProxyClassFile() {
		String name = "ProxySubject";
		byte[] data = ProxyGenerator.generateProxyClass(name, new Class[] { Subject.class });
		try {
			FileOutputStream out = new FileOutputStream(name + ".class");
			out.write(data);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
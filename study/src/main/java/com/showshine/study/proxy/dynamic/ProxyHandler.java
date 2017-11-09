package com.showshine.study.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类。用来代理和封装真实主题
 * 
 * @author showshine
 * @since 1.0
 * @version 2017年11月9日
 */
public class ProxyHandler implements InvocationHandler {
	private Object proxied;

	public ProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 在转调具体目标对象之前，可以执行一些功能处理

		// 转调具体目标对象的方法
		return method.invoke(proxied, args);

		// 在转调具体目标对象之后，可以执行一些功能处理
	}
}
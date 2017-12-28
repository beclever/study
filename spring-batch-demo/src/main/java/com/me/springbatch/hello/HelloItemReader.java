package com.me.springbatch.hello;

import org.springframework.batch.item.ItemReader;

/**
 * {@link ItemReader} with hard-coded input data.
 */
public class HelloItemReader implements ItemReader<String> {

	private int index = 0;
	/**
	 * 模拟读操作
	 */
	public String read() throws Exception {
		if (index < 1000) {
			index++;
			return "Hello world!" + index;
		} else {
			return null;
		}
	}
}

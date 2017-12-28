package com.me.springbatch.hello;

import org.springframework.batch.item.ItemProcessor;

public class HelloItemProcessor implements ItemProcessor<String, String> {

	/**
	 * 模拟处理过程
	 */
	public String process(String item) throws Exception {
		// TODO Auto-generated method stub
		return item + " processed";
	}

}

package com.me.springbatch.hello;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
public class HelloItemWriter implements ItemWriter<Object> {

	private static final Log log = LogFactory.getLog(HelloItemWriter.class);

	/**
	 * 模拟写操作
	 * 
	 * @see ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends Object> data) throws Exception {
		log.info(data);
	}

}

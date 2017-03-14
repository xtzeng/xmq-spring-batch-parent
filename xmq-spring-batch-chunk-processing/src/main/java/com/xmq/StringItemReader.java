/**
 * 
 */
package com.xmq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 *
 */
public class StringItemReader implements ItemReader<String> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StringItemReader.class);
	
	private List<String> list;
	
	public StringItemReader() {
		// TODO 01 fill in the list with String objects
		this.list = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7"));
	}

	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemReader#read()
	 */
	@Override
	public String read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		// TODO 02 remove items from the list until it's empty
		return !list.isEmpty() ? list.remove(0) : null;
	}

}

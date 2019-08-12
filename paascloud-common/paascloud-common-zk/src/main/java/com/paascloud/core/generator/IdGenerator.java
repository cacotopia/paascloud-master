package com.paascloud.core.generator;

/**
 * The interface Id generator.
 *
 * @author walkman
 */
public interface IdGenerator {

	/**
	 * 生成下一个ID
	 *
	 * @return the string
	 */
	Long nextId();
}

package com.supos.cloud.core.support;

import com.supos.cloud.base.dto.BaseTree;

import java.io.Serializable;
import java.util.List;

/**
 * The interface Tree interface.
 *
 * @param <T>  the type parameter
 * @param <ID> the type parameter
 *
 * @author walkman
 */
public interface ITree<T extends BaseTree<T, ID>, ID extends Serializable> {
	/**
	 * 获得指定节点下所有归档
	 *
	 * @param list     the list
	 * @param parentId the parent id
	 *
	 * @return the child tree objects
	 */
	List<T> getChildTreeObjects(List<T> list, ID parentId);

	/**
	 * 递归列表
	 *
	 * @param list the list
	 * @param t    the t
	 */
	void recursionFn(List<T> list, T t);

	/**
	 * 获得指定节点下的所有子节点
	 *
	 * @param list the list
	 * @param t    the t
	 *
	 * @return the child list
	 */
	List<T> getChildList(List<T> list, T t);

	/**
	 * 判断是否还有下一个子节点
	 *
	 * @param list the list
	 * @param t    the t
	 *
	 * @return the boolean
	 */
	boolean hasChild(List<T> list, T t);
}
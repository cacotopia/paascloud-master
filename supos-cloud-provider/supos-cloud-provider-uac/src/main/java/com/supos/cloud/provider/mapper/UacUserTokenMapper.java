package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.UacUserToken;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * The interface Uac user token mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface UacUserTokenMapper extends MyMapper<UacUserToken> {
	/**
	 * Select token list list.
	 *
	 * @param userToken the user token
	 *
	 * @return the list
	 */
	List<UacUserToken> selectTokenList(UacUserToken userToken);

	/**
	 * 超时token更新为离线.
	 *
	 * @param map the map
	 *
	 * @return the int
	 */
	int batchUpdateTokenOffLine(Map<String, Object> map);

	/**
	 * 查询超时token Id 集合.
	 *
	 * @return the list
	 */
	List<Long> listOffLineTokenId();
}
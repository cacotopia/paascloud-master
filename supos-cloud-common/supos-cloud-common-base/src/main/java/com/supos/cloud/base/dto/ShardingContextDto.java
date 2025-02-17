package com.supos.cloud.base.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The class Sharding context dto.
 *
 * @author walkman
 */
@Data
@NoArgsConstructor
public class ShardingContextDto {
	/**
	 * The Sharding total count.
	 */
	int shardingTotalCount;
	/**
	 * The Sharding item.
	 */
	int shardingItem;

	public ShardingContextDto(final int shardingTotalCount, final int shardingItem) {
		this.shardingTotalCount = shardingTotalCount;
		this.shardingItem = shardingItem;
	}
}

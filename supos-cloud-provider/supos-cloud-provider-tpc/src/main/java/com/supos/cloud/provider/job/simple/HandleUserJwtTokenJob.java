//
//package com.supos.cloud.provider.job.simple;
//
//import com.dangdang.ddframe.job.api.ShardingContext;
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//import com.supos.cloud.elastic.lite.annotation.ElasticJobConfig;
//import com.supos.cloud.provider.model.service.UacRpcService;
//import lombok.extern.slf4j.Slf4j;
//
//import javax.annotation.Resource;
//
///**
// * The class Spring simple job.
// *
// * @author walkman
// */
//@Slf4j
//@ElasticJobConfig(cron = "0 0/30 * * * ?")
//public class HandleUserJwtTokenJob implements SimpleJob {
//	@Resource
//	private UacRpcService uacRpcService;
//
//	/**
//	 * Execute.
//	 *
//	 * @param shardingContext the sharding context
//	 */
//	@Override
//	public void execute(final ShardingContext shardingContext) {
//		uacRpcService.batchUpdateTokenOffLine();
//	}
//}

package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.OptAttachment;
import com.supos.cloud.provider.model.dto.attachment.OptAttachmentReqDto;
import com.supos.cloud.provider.model.dto.attachment.OptAttachmentRespDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Opt attachment mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface OptAttachmentMapper extends MyMapper<OptAttachment> {
	/**
	 * Query attachment list.
	 *
	 * @param optAttachmentReqDto the opt attachment req dto
	 *
	 * @return the list
	 */
	List<OptAttachmentRespDto> queryAttachment(OptAttachmentReqDto optAttachmentReqDto);

	/**
	 * Query attachment by ref no list.
	 *
	 * @param refNo the ref no
	 *
	 * @return the list
	 */
	List<Long> queryAttachmentByRefNo(@Param("refNo") String refNo);

	/**
	 * Delete by id list int.
	 *
	 * @param attachmentIdList the attachment id list
	 *
	 * @return the int
	 */
	int deleteByIdList(@Param("idList") List<Long> attachmentIdList);

	/**
	 * List expire file list.
	 *
	 * @return the list
	 */
	List<OptAttachment> listExpireFile();
}
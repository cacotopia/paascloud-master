package com.supos.cloud.provider.service;

import com.supos.cloud.provider.model.dto.oss.OptUploadFileRespDto;
import com.qiniu.common.QiniuException;

import java.io.IOException;
import java.util.Set;

/**
 * The interface Opc oss service.
 *
 * @author walkman
 */
public interface OpcOssService {

	/**
	 * 删除文件
	 *
	 * @param fileName   文件路径 + 文件名
	 * @param bucketName oss对象名称
	 *
	 * @throws QiniuException the qiniu exception
	 */
	void deleteFile(String fileName, String bucketName) throws QiniuException;

	/**
	 * Batch delete file set.
	 *
	 * @param fileNameList the file name list
	 * @param bucketName   the bucket name
	 *
	 * @return the set
	 *
	 * @throws QiniuException the qiniu exception
	 */
	Set<String> batchDeleteFile(String[] fileNameList, String bucketName) throws QiniuException;

	/**
	 * 获取查看文件的Url
	 *
	 * @param domainOfBucket the domain of bucket
	 * @param fileName       文件路径 + 文件名
	 * @param expires        失效时间
	 *
	 * @return the file url
	 */
	String getFileUrl(String domainOfBucket, String fileName, Long expires);

	/**
	 * Gets file url.
	 *
	 * @param domainOfBucket the domain of bucket
	 * @param fileName       the file name
	 *
	 * @return the file url
	 */
	String getFileUrl(String domainOfBucket, String fileName);

	/**
	 * Upload file opt upload file resp dto.
	 *
	 * @param uploadBytes the upload bytes
	 * @param fileName    the file name
	 * @param filePath    the file path
	 * @param bucketName  the bucket name
	 *
	 * @return the opt upload file resp dto
	 *
	 * @throws IOException the io exception
	 */
	OptUploadFileRespDto uploadFile(byte[] uploadBytes, String fileName, String filePath, String bucketName) throws IOException;
}

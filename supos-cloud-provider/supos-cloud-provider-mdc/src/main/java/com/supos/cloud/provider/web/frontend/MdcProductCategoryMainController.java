package com.supos.cloud.provider.web.frontend;

import com.supos.cloud.base.dto.LoginAuthDto;
import com.supos.cloud.base.dto.UpdateStatusDto;
import com.supos.cloud.core.annotation.LogAnnotation;
import com.supos.cloud.core.support.BaseController;
import com.supos.cloud.provider.model.domain.MdcProductCategory;
import com.supos.cloud.provider.model.dto.MdcEditCategoryDto;
import com.supos.cloud.provider.model.vo.MdcCategoryVo;
import com.supos.cloud.provider.service.MdcProductCategoryService;
import com.supos.cloud.wrapper.WrapMapper;
import com.supos.cloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Mdc category main controller.
 *
 * @author walkman
 */
@RestController
@RequestMapping(value = "/category", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - MdcProductCategoryMainController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MdcProductCategoryMainController extends BaseController {

	@Resource
	private MdcProductCategoryService mdcProductCategoryService;

	/**
	 * 获取商品分类列表数据
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/getTree")
	@ApiOperation(httpMethod = "POST", value = "获取商品分类树")
	public Wrapper<List<MdcCategoryVo>> queryCategoryTreeList() {
		List<MdcCategoryVo> categoryVoList = mdcProductCategoryService.getCategoryTreeList();
		return WrapMapper.ok(categoryVoList);
	}

	/**
	 * 根据ID获取商品分类信息.
	 *
	 * @param id the id
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/queryById/{id}")
	@ApiOperation(httpMethod = "POST", value = "根据ID获取商品分类信息")
	public Wrapper<MdcCategoryVo> queryCategoryVoById(@ApiParam(name = "id", value = "商品分类id") @PathVariable Long id) {
		logger.info("根据Id查询商品分类信息, categoryId={}", id);
		MdcCategoryVo mdcCategoryVo = mdcProductCategoryService.getMdcCategoryVoById(id);
		return WrapMapper.ok(mdcCategoryVo);
	}


	/**
	 * 根据id修改商品分类的禁用状态
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/modifyStatus")
	@ApiOperation(httpMethod = "POST", value = "根据id修改商品分类的禁用状态")
	@LogAnnotation
	public Wrapper updateMdcCategoryStatusById(@ApiParam(name = "mdcCategoryStatusDto", value = "修改商品分类状态Dto") @RequestBody UpdateStatusDto updateStatusDto) {
		logger.info("根据id修改商品分类的禁用状态 updateStatusDto={}", updateStatusDto);
		LoginAuthDto loginAuthDto = getLoginAuthDto();
		mdcProductCategoryService.updateMdcCategoryStatusById(updateStatusDto, loginAuthDto);
		return WrapMapper.ok();
	}

	@PostMapping(value = "/save")
	@ApiOperation(httpMethod = "POST", value = "编辑商品分类")
	@LogAnnotation
	public Wrapper saveCategory(@ApiParam(name = "saveCategory", value = "编辑商品分类") @RequestBody MdcEditCategoryDto mdcCategoryAddDto) {
		MdcProductCategory mdcCategory = new MdcProductCategory();
		LoginAuthDto loginAuthDto = getLoginAuthDto();
		BeanUtils.copyProperties(mdcCategoryAddDto, mdcCategory);
		mdcProductCategoryService.saveMdcCategory(mdcCategory, loginAuthDto);
		return WrapMapper.ok();
	}

	/**
	 * 根据id删除商品分类
	 *
	 * @param id the id
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/deleteById/{id}")
	@ApiOperation(httpMethod = "POST", value = "根据id删除商品分类")
	@LogAnnotation
	public Wrapper<Integer> deleteMdcCategoryById(@ApiParam(name = "id", value = "商品分类id") @PathVariable Long id) {
		logger.info(" 根据id删除商品分类 id={}", id);
		// 判断此商品分类是否有子节点
		boolean hasChild = mdcProductCategoryService.checkCategoryHasChildCategory(id);
		if (hasChild) {
			return WrapMapper.wrap(Wrapper.ERROR_CODE, "此商品分类含有子商品分类, 请先删除子商品分类");
		}

		int result = mdcProductCategoryService.deleteByKey(id);
		return super.handleResult(result);
	}
}
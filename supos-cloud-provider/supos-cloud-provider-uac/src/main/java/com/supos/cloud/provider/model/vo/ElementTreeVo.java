package com.supos.cloud.provider.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * The class Element tree vo.
 *
 * @author walkman
 */
@Data
public class ElementTreeVo implements Serializable {
    private static final long serialVersionUID = -7266614376023024646L;

    private String label;

    private List<ElementTreeVo> children;
}

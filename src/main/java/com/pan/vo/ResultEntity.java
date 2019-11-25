package com.pan.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 请求返回实体类
 *
 * @author weiQiang
 * @date 2019/11/25
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor
@Builder
@ApiModel("请求返回实体类")
public class ResultEntity implements Serializable {

    private static final long serialVersionUID = -5159330866402406443L;
    /**
     * 返回结果
     */
    @ApiModelProperty(value = "返回结果数据")
    private List<?> data;
    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回结果提示信息")
    private String message;
    /**
     * 是否分页
     */
    @ApiModelProperty(value = "是否分页")
    private boolean pageable;
    /**
     * 返回成功与否
     */
    @ApiModelProperty(value = "返回结果状态")
    private boolean success;
    /**
     * 数据条数
     */
    @Builder.Default
    @ApiModelProperty(value = "返回结果数据条数")
    private Long total = 0L;
    /**
     * 耗时
     */
    @Builder.Default
    @ApiModelProperty(value = "请求耗时,单位ms")
    private Long totalTime = 0L;

}

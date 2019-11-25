package com.pan.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 请求返回实体类，含分页信息
 *
 * @author weiQiang
 * @date 2019/11/25
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@ApiModel("请求返回实体类，含分页信息")
public class PageResultEntity<T> implements Serializable {

    private static final long serialVersionUID = -5159330866402406443L;

    /**
     * 返回结果
     */
    @ApiModelProperty(value = "返回结果数据")
    private T data;
    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回结果提示信息")
    private String msg;
    /**
     * 返回成功与否
     */
    @ApiModelProperty(value = "返回结果状态")
    private boolean success;

    /**
     * 耗时
     */
    @Builder.Default
    @ApiModelProperty(value = "请求耗时,单位ms")
    private Long totalTime = 0L;

    /**
     * 总记录数
     */
    @Builder.Default
    @ApiModelProperty(value = "返回结果数据条数")
    private Long total = 0L;
    /**
     * 当前页
     */
    @Builder.Default
    @ApiModelProperty(value = "返回结果当前页码")
    private int pageNum = 1;

    /**
     * 每页的数量
     */
    @Builder.Default
    @ApiModelProperty(value = "返回结果每页的数量")
    private int pageSize = 10;

    /**
     * 当前页的数量
     */
    @Builder.Default
    @ApiModelProperty(value = "返回结果当前页的数量")
    private int size;

    /**
     * 总页数
     */
    @Builder.Default
    @ApiModelProperty(value = "返回结果总页数")
    private int pages;
}

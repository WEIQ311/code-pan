package com.pan.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 对象模型
 *
 * @author weiQiang
 * @date 2019/11/25
 */
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ObjectInfo<E> implements Serializable {
    private static final long serialVersionUID = -1018021034105955989L;

    /**
     * 主键集合
     */
    @NotNull(message = "主键ID不能为空!")
    @Valid
    private List<E> ids;
}

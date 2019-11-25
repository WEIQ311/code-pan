package com.pan.utils;

import com.github.pagehelper.PageInfo;
import com.pan.enums.GlobalEnum;
import com.pan.vo.ResultEntity;

import java.util.List;

/**
 * 返回结果封装工具类
 *
 * @author weiQiang
 * @date 2019/11/25
 */
public class ResultUtil {

    /**
     * 失败方法
     *
     * @param globalEnum
     * @return
     */
    public static ResultEntity error(GlobalEnum globalEnum) {
        return error(globalEnum.getMessage());
    }


    /**
     * 失败方法
     *
     * @param message
     * @return
     */
    public static ResultEntity error(String message) {
        return error(message, null);
    }


    /**
     * 失败方法
     *
     * @param message
     * @param data
     * @return
     */
    public static ResultEntity error(String message, List data) {
        return ResultEntity.builder().success(false).message(message).data(data).build();
    }


    /**
     * 操作成功
     *
     * @return ResultEntity
     */
    public static ResultEntity msg() {
        return ResultEntity.builder().success(true).message(GlobalEnum.MsgOperationSuccess.getMessage()).build();
    }

    /**
     * 操作成功、失败
     *
     * @param total 数据
     * @param count 数量
     * @return ResultEntity
     */
    public static ResultEntity msg(Object[] total, int count) {
        if (total.length == count) {
            return ResultEntity.builder().success(true).message(GlobalEnum.MsgOperationSuccess.getMessage()).build();
        } else {
            return msg(count);
        }
    }

    /**
     * 操作成功、失败
     *
     * @param count 数量
     * @return ResultEntity
     */
    public static ResultEntity msg(Integer count) {
        if (isIntThanZero(count)) {
            return ResultEntity.builder().success(true).message(GlobalEnum.MsgOperationSuccess.getMessage()).build();
        }
        return ResultEntity.builder().success(false).message(GlobalEnum.MsgOperationFailed.getMessage()).build();
    }

    /**
     * 判断整数是否大于零
     *
     * @param number
     * @return
     */
    public static boolean isIntThanZero(int number) {
        return number > 0;
    }


    /**
     * 成功返回分页数据和总页数
     *
     * @param querySuccess
     * @param resultList
     * @return
     */
    public static ResultEntity success(GlobalEnum querySuccess, List resultList) {
        return ResultEntity.builder().message(querySuccess.getMessage()).success(true).data(resultList).build();
    }


    /**
     * 成功方法
     *
     * @param globalEnum
     * @return
     */
    public static ResultEntity success(GlobalEnum globalEnum) {
        return success(globalEnum.getMessage(), null);
    }


    /**
     * 成功方法
     *
     * @param message
     * @param data
     * @return
     */
    public static ResultEntity success(String message, List data) {
        return ResultEntity.builder().success(true).message(message).data(data).build();
    }


    /**
     * 分页返回
     *
     * @param querySuccess
     * @param pageInfo
     * @return
     */
    public static ResultEntity success(GlobalEnum querySuccess, PageInfo pageInfo) {
        return ResultEntity.builder().message(querySuccess.getMessage()).success(true).data(pageInfo.getList()).pageable(true).total(pageInfo.getTotal()).build();
    }


}

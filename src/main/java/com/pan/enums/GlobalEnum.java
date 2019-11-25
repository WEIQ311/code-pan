package com.pan.enums;

/**
 * 全局枚举信息
 *
 * @author weiQiang
 * @date 2019/11/25
 */
public enum GlobalEnum {

    /**
     * 全局状态信息
     */
    QuerySuccess("查询成功!"),

    QueryError("查询失败!"),

    InsertSuccess("增加成功!"),

    InsertError("增加失败!"),

    ImportSuccess("导入成功!"),

    ImportError("导入失败!"),

    DataEmpty("数据为空!"),

    DeleteSuccess("删除成功!"),

    DeleteError("删除失败!"),

    FileEmpty("文件信息为空!"),

    DeleteNoSupport("删除不被允许!"),

    UpdateSuccess("更新成功!"),

    UpdateError("更新失败!"),

    SendSuccess("发送成功!"),

    SendError("发送成功!"),

    ServerUsed("服务忙，请稍后重试!"),

    PkIdEmpty("主键ID为空!"),

    ExceptionMessage("发生了错误:%s"),

    MsgOperationSuccess("操作成功"),

    MsgOperationFailed("操作失败"),

    LogSysNoOpen("日志系统未开启"),

    IndexCreateSuccess("索引创建成功!"),

    IndexExist("索引已经存在!"),

    IndexNoExist("索引不存在!"),

    OriFilePathEmpty("原始文件为空或不存在!"),

    TargetFilePathEmpty("目标文件路径为空!"),

    FileTypeNoSupport("文件类型暂时不支持!"),

    FileConvertError("转换文件失败"),

    NoLogin("未登录"),
    ;


    private String message;

    GlobalEnum(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }


}

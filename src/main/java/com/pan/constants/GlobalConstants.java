package com.pan.constants;

/**
 * 常量
 *
 * @author weiQiang
 * @date 2019/11/25
 */
public class GlobalConstants {

    /**
     * false
     */
    public static final Integer BOOLEAN_FALSE = 0;
    /**
     * true
     */
    public static final Integer BOOLEAN_TRUE = 1;
    /**
     * 当前登陆客户端用户信息
     */
    public static final String CLIENT_INFO = "clientInfo";
    /**
     * 客户端Ip
     */
    public static final String CLIENT_IP = "clientIp";
    /**
     * 格式化时间格式
     */
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 格式化时间格式
     */
    public static final String DATE_TIME_FORMATTER = "yyyyMMddHHmmss";
    /**
     * 格式化时间格式
     */
    public static final String DATE_FORMATTER = "yyyyMMdd";
    /**
     * 默认排名
     */
    public static final Integer DEFAULT_RANKING = 1;
    /**
     * 后缀
     */
    public static final String DEFAULT_SUFFIX = ")";
    /**
     * 导入文件sheet切分长度
     */
    public static final Integer EXCEL_SHEET_LENGTH = 3;
    /**
     * EXCEL类型
     */
    public static final String EXCEL_TYPE_XLS = "xls";
    /**
     * EXCEL类型
     */
    public static final String EXCEL_TYPE_XLSX = "xlsx";
    /**
     * 上传文件配置key
     */
    public static final String FORM_DATA_KEY = "formData";
    /**
     * 5次登陆失败
     */
    public static final int FREQUENTLY_LOGIN_COUNT = 5;
    /**
     * 最大尝试登陆失败次数
     */
    public static final int FREQUENTLY_MAX_LOGIN_ERROR_COUNT = 15;
    /**
     * 逗号
     */
    public static final String INTERVAL_COMMA = ",";
    /**
     * 间隔号
     */
    public static final String INTERVAL_NUMBER = "`";
    /**
     * 点
     */
    public static final String INTERVAL_POINT = "\\.";
    /**
     * 点
     */
    public static final String POINT = ".";
    /**
     * token密钥
     */
    public static final String LEXICAL_XSD_BASE64_BINARY = "commonInfo";
    /**
     * linux
     */
    public static final String LINUX_NAME = "linux";
    /**
     * ok
     */
    public static final String OK = "OK";
    /**
     * 请求类型options
     */
    public static final String OPERATE_METHOD = "OPTIONS";
    /**
     * 增加方法
     */
    public static final String OPERATE_TYPE_INSERT = "insert";
    /**
     * 更新方法
     */
    public static final String OPERATE_TYPE_UPDATE = "update";
    /**
     * 升序
     */
    public static final String ORDER_ASC = "ASC";
    /**
     * 降序
     */
    public static final String ORDER_DESC = "DESC";
    /**
     * 问号
     */
    public static final String QUERY_MARK = "?";
    /**
     * 一天(毫秒)
     */
    public static final Integer SECONDS_ONE_DAY = 1000 * 60 * 60 * 24;
    /**
     * 一小时(毫秒)
     */
    public static final Integer SECONDS_ONE_HOUR = 1000 * 60 * 60;
    /**
     * 一分钟(毫秒)
     */
    public static final Integer SECONDS_ONE_MINUTE = 60000;
    /**
     * 两天(毫秒)
     */
    public static final Integer SECONDS_TWO_DAY = 1000 * 60 * 60 * 48;
    /**
     * 两分钟(毫秒)
     */
    public static final Integer SECONDS_TWO_MINUTE = 2 * 60 * 1000;
    /**
     * 空格
     */
    public static final String SPACE = " ";
    /**
     * 成功
     */
    public static final String SUCCESS = "success";
    /**
     * token拥有者
     */
    public static final String TOKEN_ISSUER = "com.pan";
    /**
     * token再请求头中的Key
     */
    public static final String TOKEN_HEADER = "api_token";
    /**
     * token超时时间
     */
    public static final Integer TOKEN_TIME_OUT = SECONDS_TWO_DAY + SECONDS_ONE_MINUTE;
    /**
     * 下划线
     */
    public static final String UNDER_LINE = "_";
    /**
     * 常量:未知
     */
    public static final String UNKNOWN = "unknown";
    /**
     * 更新
     */
    public static final String UPDATE = "update";
    /**
     * xml请求
     */
    public static final String XML_HTTP_REQUEST = "XMLHttpRequest";
    /**
     * 请求类型
     */
    public static final String X_REQUESTED_WIDTH = "X-Requested-With";

    /**
     * 多线程名称
     */
    public static final String THREAD_NAME = "common_thread_";

    /**
     * User-Agent
     */
    public static final String USER_AGENT = "User-Agent";

    /**
     * message
     */
    public static final String CODE_MESSAGE = "message";

    /**
     * ok code
     */
    public static final String CODE_OK = "success";

    /**
     * body
     */
    public static final String CODE_BODY = "body";

    /**
     * Cookie
     */
    public static final String COOKIE_VALUE = "Set-Cookie";

}

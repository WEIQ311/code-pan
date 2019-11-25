package com.pan.utils;

import com.pan.enums.GlobalEnum;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;

import static com.pan.constants.GlobalConstants.*;

/**
 * 全局工具类
 *
 * @author weiQiang
 * @date 2019/11/25
 */
@Slf4j
public class GlobalUtils {

    /**
     * java字段转数据库字段
     *
     * @param column 排序字段
     * @return String
     */
    public static String changeColumn(String column, String direction) {
        if (StringUtils.isNotBlank(column)) {
            StringBuilder columnBuilder = new StringBuilder();
            char[] chars = column.toCharArray();
            for (char aChar : chars) {
                if (Character.isUpperCase(aChar)) {
                    columnBuilder.append(UNDER_LINE);
                    columnBuilder.append(String.valueOf(aChar).toLowerCase());
                } else {
                    columnBuilder.append(aChar);
                }
            }
            if (StringUtils.isBlank(direction)) {
                direction = ORDER_ASC;
            }
            return columnBuilder.toString() + SPACE + direction;
        }
        return "";
    }


    /**
     * 创建目录
     *
     * @param path
     * @return
     */
    public static String createDir(String path) {
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }
        path = winOrLinuxPath(path);
        File unZipFileDir = new File(path);
        if (!unZipFileDir.exists()) {
            unZipFileDir.mkdirs();
        }
        return path;
    }


    /**
     * 根据系统转换为windows格式或者linux格式
     *
     * @param path 路径
     * @return
     */
    public static String winOrLinuxPath(String path) {
        if (!isOsLinux()) {
            path = path.replace("/", "\\");
        }
        return path;
    }


    /**
     * 判断是否是linux系统
     *
     * @return
     */
    public static boolean isOsLinux() {
        Properties properties = System.getProperties();
        String os = properties.getProperty("os.name");
        return os != null && os.toLowerCase().indexOf(LINUX_NAME) > -1;
    }


    /**
     * 获取IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(INTERVAL_COMMA) && ip.split(INTERVAL_COMMA).length > 1) {
            ip = ip.split(INTERVAL_COMMA)[0];
        }
        return ip;
    }


    /**
     * 判断是否ajax请求.
     * 可以看到Ajax 请求多了个 x-requested-with ，可以利用它，
     * request.getHeader("x-requested-with"); 为 null，则为传统同步请求，为 XMLHttpRequest，则为Ajax 异步请求。
     *
     * @param request HttpServletRequest
     * @return 是否ajax请求.
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String xr = request.getHeader(X_REQUESTED_WIDTH);
        return (xr != null && XML_HTTP_REQUEST.equalsIgnoreCase(xr));
    }


    /**
     * 通用主键
     *
     * @return
     */
    public synchronized static String ordinaryId() {
        Integer count = 6;
        return ordinaryId(count);
    }


    /**
     * 通用主键
     *
     * @param count 随机数个数
     * @return String
     */
    public synchronized static String ordinaryId(Integer count) {
        return DateFormatUtils.format(new Date(), DATE_TIME_FORMATTER) + RandomStringUtils.randomNumeric(count);
    }


    /**
     * 发送响应流方法
     *
     * @param response 响应
     * @param fileName 文件名称
     */
    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            fileName = new String(fileName.getBytes(), "ISO8859-1");
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            GlobalUtils.convertMessage(GlobalEnum.ExceptionMessage, ex.getMessage());
        }
    }


    /**
     * 转换异常信息
     *
     * @param globalEnum 异常提示
     * @param args       参数
     */
    public static void convertMessage(GlobalEnum globalEnum, String... args) {
        String message = globalEnum.getMessage();
        convertMessage(message, args);
    }


    /**
     * 转换异常信息
     *
     * @param message 异常提示
     * @param args    参数
     */
    public static void convertMessage(String message, String... args) {
        message = convertMsg(message, args);
        throw new RuntimeException(message);
    }

    /**
     * 转换异常信息
     *
     * @param globalEnum 异常提示
     * @param args       参数
     * @return String
     */
    public static String convertMsg(GlobalEnum globalEnum, String... args) {
        return convertMsg(globalEnum.getMessage(), args);
    }

    /**
     * 转换异常信息
     *
     * @param message 异常提示
     * @param args    参数
     * @return String
     */
    public static String convertMsg(String message, String... args) {
        message = String.format(message, args);
        return message;
    }

    /**
     * 获取本地公网ip
     */
    public static String getIP() {
        try {
            //获取所有接口，并放进枚举集合中，然后使用Collections.list()将枚举集合转换为ArrayList集合
            Enumeration<NetworkInterface> enu = NetworkInterface.getNetworkInterfaces();
            ArrayList<NetworkInterface> arr = Collections.list(enu);
            for (Iterator<NetworkInterface> it = arr.iterator(); it.hasNext(); ) {
                NetworkInterface ni = it.next();
                //获取接口名
                String intName = ni.getName();
                String displayName = ni.getDisplayName();
                if (!intName.equals("ppp2")) {
                    continue;
                }
                //获取每个接口中的所有ip网络接口集合，因为可能有子接口
                ArrayList<InetAddress> inets = Collections.list(ni.getInetAddresses());
                for (Iterator<InetAddress> it1 = inets.iterator(); it1.hasNext(); ) {
                    InetAddress inet = it1.next();
                    //只筛选ipv4地址，否则会同时得到Ipv6地址
                    if (inet instanceof Inet4Address) {
                        String ip = inet.getHostAddress();
                        return ip;

                    }
                }
            }
        } catch (SocketException s) {
            s.printStackTrace();
        }
        return null;
    }

    /**
     * 获取发起请求的浏览器名称
     */
    public static String getBrowserName(HttpServletRequest request) {
        String header = request.getHeader(USER_AGENT);
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        Browser browser = userAgent.getBrowser();
        return Objects.isNull(browser.getName()) ? "未识别出浏览器" : browser.getName();
    }

    /**
     * 获取发起请求的浏览器版本号
     */
    public static String getBrowserVersion(HttpServletRequest request) {
        String header = request.getHeader(USER_AGENT);
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        //获取浏览器信息
        Browser browser = userAgent.getBrowser();
        //获取浏览器版本号
        Version version = browser.getVersion(header);
        return Objects.isNull(version.getVersion()) ? "未识别出操作系统" : version.getVersion();
    }

    /**
     * 获取发起请求的操作系统名称
     */
    public static String getOsName(HttpServletRequest request) {
        String header = request.getHeader(USER_AGENT);
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        return Objects.isNull(operatingSystem.getName()) ? "未识别出操作系统" : operatingSystem.getName();
    }

}

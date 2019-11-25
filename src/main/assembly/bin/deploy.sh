#!/usr/bin/env bash
# 这里可以根据项目替换为程序artifactId-version.jar,其他代码无需更改
APP_NAME=code-pan-0.0.1-SNAPSHOT.jar

# 使用说明，用来提示输入参数
usage(){
    echo "Usage : sh deploy.sh [start|stop|restart|status]"
    exit 1
}

# 检查程序是否在运行
is_exist(){
    pid=`ps -ef|grep $APP_NAME|grep -v grep|awk '{print $2}'`
    # 如果不存在返回1,存在返回0
    if [ -z "$pid" ]; then
        return 1
     else
        return 0
    fi
}

# 启动方法
start(){
    is_exist
    if [ $? -eq "0" ]; then
        echo "$APP_NAME is already running. pid=${pid}."
    else
        nohup java -jar $APP_NAME >./nohup.out&
    fi
}

# 停止方法
stop(){
    is_exist
    if [ $? -eq "0" ];then
        kill -9 $pid
    else
        echo "${APP_NAME} is not running"
    fi
}

# 重启
restart(){
    stop
    start
}

# 输出运行状态
status(){
    is_exist
     if [ $? -eq "0" ]; then
        echo "$APP_NAME is already running. pid=${pid}."
    else
        echo "${APP_NAME} is not running"
    fi
}

# 根据输入参数,选择执行对应的方法,不输入则执行使用说明
case "$1" in
    "start")
        start
        ;;
     "stop")
        stop
        ;;
     "restart")
        restart
        ;;
     "status")
        status
        ;;
     *)
        usage
        ;;
esac


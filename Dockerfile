FROM java:8
VOLUME /tmp
# 将压缩包拷贝
ADD ./target/code-pan-0.0.1-SNAPSHOT.zip /opt/pan/
# 解压zip包
RUN unzip /opt/pan/code-pan-0.0.1-SNAPSHOT.zip -d  /opt/pan/
#定义时区参数
ENV TZ=Asia/Shanghai
# MetaspaceSize
ENV MS=512m
#设置时区
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo '$TZ' > /etc/timezone
# 保留端口配置
EXPOSE 9090
# 启动
CMD cd /opt/pan/ && java -server -jar -XX:MetaspaceSize=$MS -Xms1024m -Xmx1024m -Xmn256m -Xss256k  -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=1 code-pan-0.0.1-SNAPSHOT.jar

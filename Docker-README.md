# 生成镜像
1. docker build -t code-pan:0.0.1 .
# 导出镜像
2. docker save -o ./target/code-pan.0.0.1.tar code-pan:0.0.1
# 加载镜像
docker load -i code-pan:0.0.1.tar

# 向阿里云推送镜像,xxxxx代表真实的容器用户
docker login --username=xxxxx registry.cn-hangzhou.aliyuncs.com
# 获取版本号
docker images |grep q-frame-web
docker tag 4c2acf5b5cea registry.cn-hangzhou.aliyuncs.com/xxxxx/code-pan:0.0.1
docker push registry.cn-hangzhou.aliyuncs.com/xxxxx/code-pan:0.0.1

# 从阿里云拉取镜像
docker pull registry.cn-hangzhou.aliyuncs.com/xxxxx/code-pan:0.0.1

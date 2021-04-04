#!/bin/bash
docker stop  $(docker ps -f "name=code-pan" --format "{{.ID}}");
docker rm  $(docker ps -a  -f "name=code-pan" --format "{{.ID}}");
docker rmi registry.cn-hangzhou.aliyuncs.com/xxxxx/code-pan:0.0.1

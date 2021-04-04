#!/bin/bash
PWD = `pwd`
docker run --name code-pan:0.0.1 -p 9090:9090  -v $PWD/config:/opt/code-pan/config -v $PWD/logs:/opt/code-pan/logs -d --restart=always registry.cn-hangzhou.aliyuncs.com/xxxxxx/code-pan:0.0.1

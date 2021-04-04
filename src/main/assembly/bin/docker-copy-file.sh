#!/bin/bash
PWD = `pwd`
docker run --name code-pan -d registry.cn-hangzhou.aliyuncs.com/xxxxxx/code-pan:0.0.1 ; ctrl-c ;docker cp  code-pan:/opt/code-pan/config ./;
docker stop code-pan ; docker rm code-pan;

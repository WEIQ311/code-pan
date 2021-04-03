package com.pan.command;

import com.alibaba.fastjson.JSONObject;
import com.pan.service.ElfinderStorage;

import javax.servlet.http.HttpServletRequest;

public class AbortCommand extends AbstractJsonCommand implements ElfinderCommand {
    @Override
    protected void execute(ElfinderStorage elfinderStorage, HttpServletRequest request, JSONObject json) throws Exception {
        json.put("error", 0);
    }
}

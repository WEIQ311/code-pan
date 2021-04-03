package com.pan.command;

import com.alibaba.fastjson.JSONObject;
import com.pan.service.ElfinderStorage;

import javax.servlet.http.HttpServletRequest;

public class EditorCommand extends AbstractJsonCommand implements ElfinderCommand {

    @Override
    protected void execute(ElfinderStorage elfinderStorage, HttpServletRequest request, JSONObject json) throws Exception {
        json.put("OnlineConvert", false);
        json.put("ZipArchive", false);
        json.put("ZohoOffice", false);
    }
}

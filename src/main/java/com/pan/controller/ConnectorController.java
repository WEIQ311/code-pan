package com.pan.controller;

import com.pan.enums.GlobalEnum;
import com.pan.utils.ResultUtil;
import com.pan.vo.ResultEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * describe:
 *
 * @author weiqiang
 * @date 2019/11/25
 */
@RestController
@RequestMapping(value = "/api/")
public class ConnectorController {

    @GetMapping(value = "connector")
    public ResultEntity connector() {
        return ResultUtil.success(GlobalEnum.QuerySuccess);
    }
}

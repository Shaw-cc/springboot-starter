package com.kimzing.base.web.info;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目基本信息Rest接口.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/26 13:33
 */
@Data
@RestController
public class BaseInfoController {

    private BaseInfoDTO baseInfoDTO;

    @GetMapping(value = "/info")
    public BaseInfoDTO info() {
        return baseInfoDTO;
    }

}

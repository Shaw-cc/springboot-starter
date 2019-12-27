package com.kimzing.base.log.impl;

import com.kimzing.base.log.LogAspect;
import com.kimzing.base.log.LogInfo;
import com.kimzing.base.utils.log.LogUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 默认日志切面处理类.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/26 11:57
 */
@Slf4j
public class DefaultLogAspect extends LogAspect {

    /**
     * 对日志信息的处理
     *
     * @param logInfo
     */
    @Override
    public void handleLogInfo(LogInfo logInfo) {
        LogUtil.info("[{}]", logInfo);
    }
}

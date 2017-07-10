package com.lpq.lct.lib.count;

/**
 * 统计处理类的基类 <br/>
 * Created by lipanquan on 2017/4/20.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/4/20
 */
abstract class HandlerBaseCount {

    /**
     * 获取CountConfig实例对象
     *
     * @return CountConfig实例对象
     */
    public CountConfig getConfig() {
        return CountConfig.config;
    }

    protected long getCurrentTime() {
        return System.currentTimeMillis();
    }
}

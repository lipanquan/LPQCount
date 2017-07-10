package com.lpq.lct.lib.count;

/**
 * App的生命周期统计 <br/>
 * Created by lipanquan on 2017/4/19.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/4/19
 */
public final class HandlerAppTimeCount extends HandlerBaseCount {

    protected HandlerAppTimeCount() {
        super();
    }

    /**
     * App启动统计回调
     *
     * @param flag 标志
     * @param args 参数
     */
    public void onStartAppTimeCountListener(String flag, Object... args) {
        CountConfig.config.getAppTimeCountListener().onStartAppTimeCountListener(flag, System.currentTimeMillis(), args);
    }

    /**
     * App退出统计回调
     *
     * @param flag 标志
     * @param args 参数
     */
    public void onExitAppTimeCountListener(String flag, Object... args) {
        CountConfig.config.getAppTimeCountListener().onExitAppTimeCountListener(flag, System.currentTimeMillis(), args);
    }
}

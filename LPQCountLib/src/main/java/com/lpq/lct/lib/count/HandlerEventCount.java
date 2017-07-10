package com.lpq.lct.lib.count;

/**
 * 事件功能统计 <br/>
 * Created by lipanquan on 2017/4/19.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/4/19
 */
public final class HandlerEventCount extends HandlerBaseCount {

    protected HandlerEventCount() {
    }

    /**
     * 事件统计
     *
     * @param flag       标志
     * @param totalSteps 总共多少步
     * @param stepNumber 第多少步数
     * @param args       参数
     */
    public void onEventCount(String flag, int totalSteps, int stepNumber, Object... args) {
        getConfig().getEventCountListener().onEventCountListener(flag, totalSteps, stepNumber, getCurrentTime(), args);
    }
}

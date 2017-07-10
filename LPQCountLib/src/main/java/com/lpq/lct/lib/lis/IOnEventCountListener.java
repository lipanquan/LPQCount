package com.lpq.lct.lib.lis;

/**
 * 设置事件统计的监听器 <br/>
 * Created by lipanquan on 2017/4/17.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/4/17
 */
public interface IOnEventCountListener {

    /**
     * 统计事件统计回调
     *
     * @param flag       标志
     * @param totalSteps 总共多少步
     * @param stepNumber 第多少步数
     * @param time       时间戳
     * @param args       参数
     */
    void onEventCountListener(String flag, int totalSteps, int stepNumber, long time, Object... args);
}

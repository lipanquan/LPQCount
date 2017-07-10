package com.lpq.lct.lib.lis;

/**
 * 设置统计时间事件统计监听器 <br/>
 * Created by lipanquan on 2017/4/17.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/4/17
 */
public interface IOnTimeCountListener {

    /**
     * 开始统计时间回调
     *
     * @param flag 标志
     * @param time 时间戳
     * @param args 参数
     */
    void onStartTimeCountListener(String flag, long time, Object... args);

    /**
     * 结束统计时间回调
     *
     * @param flag 标志
     * @param time 时间戳
     * @param args 参数
     */
    void onEndTimeCountListener(String flag, long time, Object... args);
}

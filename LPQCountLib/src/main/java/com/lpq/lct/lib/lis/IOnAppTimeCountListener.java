package com.lpq.lct.lib.lis;

/**
 * 设置App使用统计监听器 <br/>
 * Created by lipanquan on 2017/4/17.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/4/17
 */
public interface IOnAppTimeCountListener {

    /**
     * App启动统计回调
     *
     * @param flag 标志
     * @param time 时间戳
     * @param args 参数
     */
    void onStartAppTimeCountListener(String flag, long time, Object... args);

    /**
     * App后台运行回调
     *
     * @param time 时间戳
     */
    void onRunBackgroundAppTimeCountListener(long time);

    /**
     * App从后台切换至前台运行时回调
     *
     * @param flag 标志
     * @param time 时间戳
     * @param args 参数
     */
    void onResumeAppTimeCountListener(String flag, long time, Object... args);

    /**
     * App退出统计回调
     *
     * @param flag 标志
     * @param time 时间戳
     * @param args 参数
     */
    void onExitAppTimeCountListener(String flag, long time, Object... args);
}

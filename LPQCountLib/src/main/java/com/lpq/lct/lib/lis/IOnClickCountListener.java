package com.lpq.lct.lib.lis;

/**
 * 设置点击事件统计的监听器 <br/>
 * Created by lipanquan on 2017/4/17.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/4/17
 */
public interface IOnClickCountListener {

    /**
     * 统计点击事件回调
     *
     * @param flag 标志
     * @param time 时间戳
     * @param args 参数
     */
    void onClickCountListener(String flag, long time, Object... args);
}

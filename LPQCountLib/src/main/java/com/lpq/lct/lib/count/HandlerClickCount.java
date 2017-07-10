package com.lpq.lct.lib.count;

/**
 * 点击事件的统计 <br/>
 * Created by lipanquan on 2017/4/19.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/4/19
 */
public final class HandlerClickCount extends HandlerBaseCount {

    protected HandlerClickCount() {
    }

    /**
     * 统计点击事件
     *
     * @param flag 标志
     * @param args 参数
     */
    public void onClickCount(String flag, Object... args) {
        getConfig().getClickCountListener().onClickCountListener(flag, getCurrentTime(), args);
    }
}
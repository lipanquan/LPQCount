package com.lpq.lct.lib.count;

import android.os.Handler;
import android.os.Message;

/**
 * 时间统计处理器 <br/>
 * Created by lipanquan on 2017/4/19.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/4/19
 */
public final class HandlerTimeCount extends HandlerBaseCount {

    protected HandlerTimeCount() {
    }

    /**
     * 处理后台运行回调Handler——what的值
     */
    private static final int ON_APP_RUN_BACKGROUND_WHAT = 212;

    /**
     * 处理后台运行回调
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            getConfig().getAppTimeCountListener().onRunBackgroundAppTimeCountListener(getCurrentTime());
        }
    };

    /**
     * 开始统计时间回调
     *
     * @param flag 标志
     * @param args 参数
     */
    public void onStartTimeCount(String flag, Object... args) {
        handler.removeMessages(ON_APP_RUN_BACKGROUND_WHAT);
        if (!getConfig().getAppIsRunOnForegroundLastStates() && getConfig().getAppIsRunOnForegroundCurrentStates()) {
            getConfig().getCountListener().onResumeAppTimeCountListener(flag, getCurrentTime(), args);
        }
        getConfig().getTimeCountListener().onStartTimeCountListener(flag, getCurrentTime(), args);
    }

    /**
     * 结束统计时间回调
     *
     * @param flag 标志
     * @param args 参数
     */
    public void onEndTimeCount(String flag, Object... args) {
        getConfig().getTimeCountListener().onEndTimeCountListener(flag, getCurrentTime(), args);
        if (getConfig().getAppIsRunOnForegroundLastStates()) { // 后台运行
            handler.sendEmptyMessageDelayed(ON_APP_RUN_BACKGROUND_WHAT, getConfig().getGoHomeByTimeIn() * 1000);
        }
    }
}
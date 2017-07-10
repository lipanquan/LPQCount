package com.lpq.lct.lib.count;

import android.support.annotation.NonNull;

import com.lpq.lct.lib.lis.IAppRunListener;
import com.lpq.lct.lib.lis.IOnAppTimeCountListener;
import com.lpq.lct.lib.lis.IOnClickCountListener;
import com.lpq.lct.lib.lis.IOnCountListener;
import com.lpq.lct.lib.lis.IOnEventCountListener;
import com.lpq.lct.lib.lis.IOnTimeCountListener;

/**
 * 配置统一参数 <br/>
 * Created by lipanquan on 2017/4/17.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/4/17
 */
public final class CountConfig {

    /**
     * 获取App运行状态接口（由使用者实现）
     */
    private static IAppRunListener appRunListener;

    /**
     * 设置统计所有事件的监听器
     */
    private static IOnCountListener countListener;

    /**
     * 设置App使用统计监听器
     */
    private static IOnAppTimeCountListener appTimeCountListener;

    /**
     * 设置点击事件统计的监听器
     */
    private static IOnClickCountListener clickCountListener;

    /**
     * 设置事件统计的监听器
     */
    private static IOnEventCountListener eventCountListener;

    /**
     * 设置时间统计的监听器
     */
    private static IOnTimeCountListener timeCountListener;

    /**
     * 当app后台运行多久时为App新的周期（单位：秒）
     */
    private static int goHomeByTimeIn = 30;

    /**
     * App的生命周期统计
     */
    private final HandlerAppTimeCount handlerAppTimeCount;

    /**
     * 点击事件的统计
     */
    private final HandlerClickCount handlerClickCount;

    /**
     * 事件功能统计
     */
    private final HandlerEventCount handlerEventCount;

    /**
     * 时间统计处理器
     */
    private final HandlerTimeCount handlerTimeCount;

    /**
     * 标示是否在后台运行，TRUE为后台运行
     */
    private static boolean isRunOnBackground = true;

    private CountConfig() {
        isRunOnBackground = false;
        handlerAppTimeCount = new HandlerAppTimeCount();
        handlerClickCount = new HandlerClickCount();
        handlerEventCount = new HandlerEventCount();
        handlerTimeCount = new HandlerTimeCount();
    }

    /**
     * CountConfig配置
     */
    final static CountConfig config = new CountConfig();

    /**
     * 获取CountConfig配置对象
     *
     * @return CountConfig配置对象
     */
    public static CountConfig build(IAppRunListener appRunListener) {
        CountConfig.appRunListener = appRunListener;
        return config;
    }

    /**
     * 获取App的生命周期统计
     *
     * @return App的生命周期统计
     */
    public HandlerAppTimeCount getHandlerAppTimeCount() {
        return handlerAppTimeCount;
    }

    /**
     * 获取点击事件的统计
     *
     * @return 点击事件的统计
     */
    public HandlerClickCount getHandlerClickCount() {
        return handlerClickCount;
    }

    /**
     * 获取事件功能统计
     *
     * @return 事件功能统计
     */
    public HandlerEventCount getHandlerEventCount() {
        return handlerEventCount;
    }

    /**
     * 获取时间统计处理器
     *
     * @return 时间统计处理器
     */
    public HandlerTimeCount getHandlerTimeCount() {
        return handlerTimeCount;
    }

    /**
     * 获取App是否是后台运行
     *
     * @param context
     * @return
     */
//    public boolean getAppIsRunOnForeground(Context context) {
//        ActivityManager activityManager = (ActivityManager) context
//                .getSystemService(Context.ACTIVITY_SERVICE);
//        String packageName = context.getPackageName();
//        context = null;
//        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
//                .getRunningAppProcesses();
//        if (appProcesses == null)
//            return false;
//
//        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
//            if (appProcess.processName.equals(packageName)
//                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * 设置App后台运行多久新的周期（单位：秒）
     *
     * @param second 后台运行多少秒 > 0
     * @return CountConfig配置对象
     */
    public CountConfig setGoHomeByTimeIn(int second) {
        if (second < 1) {
            throw new RuntimeException("CountConfig.setGoHomeByTimeIn(int second) second参数必须大于0");
        }
        this.goHomeByTimeIn = second;
        return this;
    }

    /**
     * 获取App运行状态接口（由使用者实现）
     *
     * @return App运行状态接口实现对象
     */
    public IAppRunListener getAppRunListener() {
        return appRunListener;
    }

    /**
     * 设置统计所有事件的监听器（优先级比较高，设置此监听后addClickCountListener、addEventCountListener、addTimeCountListener方法无效）
     *
     * @param countListener 统计所有事件的监听器
     * @return CountConfig对象
     */
    public CountConfig addCountListener(@NonNull IOnCountListener countListener) {
        this.countListener = countListener;
        this.clickCountListener = null;
        this.eventCountListener = null;
        this.timeCountListener = null;
        return this;
    }

    /**
     * 设置App使用统计监听器（优先级较低，设置addCountListener此监听后该方法无效）
     *
     * @param appTimeCountListener App使用统计监听器
     * @return CountConfig对象
     */
    public CountConfig addAppTimeCountListener(@NonNull IOnAppTimeCountListener appTimeCountListener) {
        if (this.countListener == null)
            this.appTimeCountListener = appTimeCountListener;
        return this;
    }

    /**
     * 设置点击事件统计的监听器（优先级较低，设置addCountListener此监听后该方法无效）
     *
     * @param clickCountListener 点击事件统计的监听器
     * @return CountConfig对象
     */
    public CountConfig addClickCountListener(@NonNull IOnClickCountListener clickCountListener) {
        if (this.countListener == null)
            this.clickCountListener = clickCountListener;
        return this;
    }

    /**
     * 设置事件统计的监听器（优先级较低，设置addCountListener此监听后该方法无效）
     *
     * @param eventCountListener 事件统计的监听器
     * @return CountConfig对象
     */
    public CountConfig addEventCountListener(@NonNull IOnEventCountListener eventCountListener) {
        if (this.countListener == null)
            this.eventCountListener = eventCountListener;
        this.timeCountListener = null;
        return this;
    }

    /**
     * 设置时间统计的监听器（优先级较低，设置addCountListener此监听后该方法无效）
     *
     * @param timeCountListener 时间统计的监听器
     * @return CountConfig对象
     */
    public CountConfig addTimeCountListener(@NonNull IOnTimeCountListener timeCountListener) {
        if (this.countListener == null)
            this.timeCountListener = timeCountListener;
        return this;
    }


    /**
     * 获取当app后台运行多久时为App新的周期（单位：秒）
     *
     * @return 秒
     */
    public int getGoHomeByTimeIn() {
        return goHomeByTimeIn;
    }

    /**
     * 获取统计所有事件的监听器
     *
     * @return 统计所有事件的监听器
     */
    public IOnCountListener getCountListener() {
        return countListener;
    }

    /**
     * 获取App使用统计监听器
     *
     * @return App使用统计监听器
     */
    public IOnAppTimeCountListener getAppTimeCountListener() {
        if (countListener != null)
            return countListener;
        return this.appTimeCountListener;
    }

    /**
     * 获取点击事件统计的监听器
     *
     * @return 点击事件统计的监听器
     */
    public IOnClickCountListener getClickCountListener() {
        if (countListener != null)
            return countListener;
        return clickCountListener;
    }

    /**
     * 获取事件统计的监听器
     *
     * @return 事件统计的监听器
     */
    public IOnEventCountListener getEventCountListener() {
        if (countListener != null)
            return countListener;
        return eventCountListener;
    }

    /**
     * 获取时间统计的监听器
     *
     * @return 时间统计的监听器
     */
    public IOnTimeCountListener getTimeCountListener() {
        if (countListener != null)
            return countListener;
        return timeCountListener;
    }

    /**
     * 获取App最后一次运行状态
     *
     * @return App最后一次运行状态
     */
    protected boolean getAppIsRunOnForegroundLastStates() {
        return CountConfig.isRunOnBackground;
    }

    /**
     * 获取App当前运行状态
     *
     * @return App当前运行状态
     */
    protected boolean getAppIsRunOnForegroundCurrentStates() {
        if (CountConfig.appRunListener != null) {
            return (CountConfig.isRunOnBackground = CountConfig.appRunListener.getAppIsRunOnForeground());
        }
        return false;
    }
}

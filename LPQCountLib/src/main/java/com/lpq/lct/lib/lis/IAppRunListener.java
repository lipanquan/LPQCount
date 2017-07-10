package com.lpq.lct.lib.lis;

/**
 * 实现App是否是在后台运行接口 <br/>
 * Created by lipanquan on 2017/4/20.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/4/20
 */
public interface IAppRunListener {

    /**
     * 获取App是否是在后台运行
     *
     * @return 返回true为后台运行
     */
    boolean getAppIsRunOnForeground();
}

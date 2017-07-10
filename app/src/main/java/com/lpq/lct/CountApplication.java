package com.lpq.lct;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.lpq.lct.lib.count.CountConfig;
import com.lpq.lct.lib.lis.IAppRunListener;
import com.lpq.lct.lib.lis.IOnCountListener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <br/>
 * Created by lipanquan on 2017/4/19.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/4/19
 */
public class CountApplication extends Application implements IAppRunListener, IOnCountListener {

    private static CountConfig countConfig;

    public static CountConfig getCountConfig() {
        return countConfig;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        countConfig = CountConfig.build(this);
        countConfig.addCountListener(this);
        countConfig.getHandlerAppTimeCount().onStartAppTimeCountListener("CountApplication");
    }

    /**
     * 退出应用
     */
    public void exitApp(MainActivity activity) {
        getCountConfig().getHandlerAppTimeCount().onExitAppTimeCountListener("CountApplication");
        int o;
        o = 0;
        if (o == 0) {
            o = 3;
        }
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File countFile = new File(getExternalCacheDir().getAbsolutePath(), "count.txt");
            if (countFile.exists())
                countFile.delete();
            bw = new BufferedWriter(fw = new FileWriter(countFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String str : contents) {
            try {
                bw.append(str);
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (fw != null) {
            try {
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fw = null;
            }
            if (bw != null) {
                try {
                    bw.flush();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    bw = null;
                }
            }
        }
        activity.finish();
//        System.exit(0);
    }

    @Override
    public boolean getAppIsRunOnForeground() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getPackageName();
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }

    ArrayList<String> contents = new ArrayList<>();

    private void writerFile(String content) {
        contents.add(content);
    }

    @Override
    public void onClickCountListener(String flag, long time, Object... args) {
        writerFile("onClickCountListener:" + flag + time);
        Toast.makeText(getApplicationContext(), "onClickCountListener:" + flag + time, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartTimeCountListener(String flag, long time, Object... args) {
        writerFile("onStartTimeCountListener:" + flag + time);
        Toast.makeText(getApplicationContext(), "onStartTimeCountListener:" + flag + time, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEndTimeCountListener(String flag, long time, Object... args) {
        writerFile("onEndTimeCountListener:" + flag + time);
        Toast.makeText(getApplicationContext(), "onEndTimeCountListener:" + flag + time, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartAppTimeCountListener(String flag, long time, Object... args) {
        writerFile("onStartAppTimeCountListener:" + flag + time);
        Toast.makeText(getApplicationContext(), "onStartAppTimeCountListener:" + flag + time, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRunBackgroundAppTimeCountListener(long time) {
        writerFile("onRunBackgroundAppTimeCountListener:" + time);
        Toast.makeText(getApplicationContext(), "onRunBackgroundAppTimeCountListener:" + time, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResumeAppTimeCountListener(String flag, long time, Object... args) {
        writerFile("onResumeAppTimeCountListener:" + flag + time);
        Toast.makeText(getApplicationContext(), "onResumeAppTimeCountListener:" + flag + time, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onExitAppTimeCountListener(String flag, long time, Object... args) {
        writerFile("onExitAppTimeCountListener:" + flag + time);
        Toast.makeText(getApplicationContext(), "onExitAppTimeCountListener:" + flag + time, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEventCountListener(String flag, int totalSteps, int stepNumber,
                                     long time, Object... args) {
        writerFile("onEventCountListener: 第 " + stepNumber + ", 共 " + totalSteps + " 步：" + flag + time);
        Toast.makeText(getApplicationContext(), "onEventCountListener: 第 " + stepNumber + ", 共 " + totalSteps + " 步：" + flag + time, Toast.LENGTH_SHORT).show();
    }
}
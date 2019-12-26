package com.example.activitytest;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

public class ActivityCollector{
    public  static List<Activity> activities=new ArrayList<>();

    public  static void addActiivity(Activity activity){
        activities.add(activity);
    }
    public  static  void  removeActivity(Activity activity){
        activities.remove(activity);
    }
    public  static  void finshAll(){
        for (Activity a:activities) {
            if(!a.isFinishing()){
                a.finish();
            }
        }
        activities.clear();
    }
}

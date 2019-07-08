package com.example.user.airindiaengg.Helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.user.airindiaengg.BuildConfig;
import com.example.user.airindiaengg.Fragments.FacilitiesFragment;
import com.example.user.airindiaengg.Fragments.FragmentContent;
import com.example.user.airindiaengg.Interface.NavigationManager;
import com.example.user.airindiaengg.R;
import com.example.user.airindiaengg.drawer;

import java.util.Map;

import static android.content.ContentValues.TAG;

public class FragmentNavigationManager implements NavigationManager{

    private static FragmentNavigationManager mInstance;
    private FragmentManager mFragmentManager;
    private drawer mainActivity;
    private Map<String, String> map;

    public static FragmentNavigationManager getnInstance(drawer mainActivity)
    {
        if (mInstance==null)
            mInstance=new FragmentNavigationManager();
        mInstance.configure(mainActivity);
        return mInstance;
    }

    private void configure(drawer mainActivity)
    {
        mainActivity=mainActivity;
        mFragmentManager=mainActivity.getSupportFragmentManager();
    }

    @Override
    public void showFragment(String title){


        //title="Facilities";
        title=title.replaceAll("\\s+","");
        title=title+"Fragment";
        String className = "com.example.user.airindiaengg.Fragments."+title;
        try {
            Object xyz = Class.forName(className).newInstance();
            Log.d(TAG, "showFragment: " + className);
            showFragment((Fragment)xyz, false);

        }
        catch (Exception e)
        {
            Log.d(TAG, "showFragment: error"+ e);
            showFragment(FragmentContent.newInstance(title),false);
        }


    }

    public void showFragment(Fragment fragmentContent, boolean b){
        FragmentManager fm= mFragmentManager;
        FragmentTransaction ft=fm.beginTransaction().replace(R.id.container,fragmentContent);
        ft.addToBackStack(null);

        if(b||!BuildConfig.DEBUG)
            ft.commitAllowingStateLoss();
        else
            ft.commit();
        fm.executePendingTransactions();
    }
}

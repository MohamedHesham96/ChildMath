package com.example.h.childmath;

import android.app.Application;

/**
 * Created by H on 02/05/2016.
 */
public class MainApplication extends Application {

    static Boolean normal_bool = false;
    static Boolean speed_bool = false;
    static Boolean time_bool = false;
    static Boolean tran_bool = false;


    @Override
    public void onCreate() {
        super.onCreate();

    }

     static void setNormalModeTrue() {

        normal_bool = true;
        speed_bool = false;
        time_bool = false;
         tran_bool = false;

    }

    static void setSpeedModeTrue() {

        normal_bool = false;
        speed_bool = true;
        time_bool = false;
        tran_bool = false;

    }

    static void setTimeModeTrue() {

        normal_bool = false;
        speed_bool = false;
        time_bool = true;
        tran_bool = false;

    }

    static void setTranModeTrue() {

        normal_bool = false;
        speed_bool = false;
        time_bool = false;
        tran_bool = true;

    }


    static boolean getNormalMode() {

        return normal_bool;
    }

    static boolean getSpeedMode() {

      return speed_bool;
    }

    static boolean getTimeMode() {

        return speed_bool;
    }

    static boolean getTranMode() {

        return tran_bool;
    }



}

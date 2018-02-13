package cn.edu.gdmec.android.interceptcall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class OutCallReceiver extends BroadcastReceiver {
    public OutCallReceiver(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        /*throw new UnsupportedOperationException ( "Not yet implemented" );*/
        //获取拨打的电话号码
        String outcallnumber = getResultData ();
        //创建Sharedpreferences对象，获取拦截号码
        SharedPreferences sp=context.getSharedPreferences ( "config", Context.MODE_PRIVATE );
        String number=sp.getString ( "number", "" );
        //判断是否是拦截号码
        if (outcallnumber.equals ( number )){
            //清除电话
            setResultData ( null );
        }
    }
}

package dev.xesam.android.ndk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    static {
        System.loadLibrary("ndk-tools");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.getPackageName)
    public void ndkGetPackageName(Button btn) {
        btn.setText(NdkTools.getPackageName(getApplicationContext()));
    }

    @OnClick(R.id.getDeviceId)
    public void ndkGetDeviceId(Button btn) {
        btn.setText(NdkTools.getDeviceId(getApplicationContext()));
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.getDeviceId();
    }
}

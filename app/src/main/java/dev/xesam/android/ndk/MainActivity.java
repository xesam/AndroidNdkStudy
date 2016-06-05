package dev.xesam.android.ndk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    static {
        System.loadLibrary("ndk-tools");
    }

    static int[] NUMBERS = {10, 32, 43, 56};

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
    }

    @OnClick(R.id.getValue)
    public void getValue(Button btn) {
        btn.setText(NdkTools.getValue(NUMBERS, 2) + "");
    }

}

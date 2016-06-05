# AndroidNdkStudy

现阶段 Android Studio 对 NDK 的支持不是很完整，所以 jni 文件夹不要放在 main 文件夹下面。
为了方便编译，最好是用脚本来控制目录的生成和移动。

测试目录 <workspace_loc>/<module_loc>/src

    ruby ndk.rb javah dev.xesam.android.ndk.NdkTools
    ruby ndk.rb build


     
     
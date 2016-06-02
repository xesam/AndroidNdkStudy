LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS) # 清除除了 LOCAL_PATH 之外的 LOCAL_* 变量

LOCAL_MODULE    := ndk-tools # 设定一个唯一的名称
LOCAL_SRC_FILES := dev_xesam_android_ndk_NdkTools.c # 模块的源文件列表

include $(BUILD_SHARED_LIBRARY)



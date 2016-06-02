//
// Created by xe on 16-6-2.
//

#include <jni.h>
#include <stdio.h>
#include "ndk_tools.h"

jstring Java_getPackageName(JNIEnv* env, jobject context){
    if(context == 0){
		//return (*env)->NewStringUTF(env, "[+] Error: Context is 0");
		return NULL;
	}

	jclass cls_context = (*env)->FindClass(env, "android/content/Context");
	if(cls_context == 0){
		//return (*env)->NewStringUTF(env, "[+] Error: FindClass <android/content/Context> Error");
		return NULL;
	}

	jmethodID getPackageName = (*env)->GetMethodID(env, cls_context, "getPackageName", "()Ljava/lang/String;");
	if(getPackageName == 0){
		//return (*env)->NewStringUTF(env, "[+] Error: GetMethodID failed");
		return NULL;
	}

	jstring packageName = (*env)->CallObjectMethod(env, context, getPackageName);
	if(packageName == 0){
		//return (*env)->NewStringUTF(env, "[+] Error: CallObjectMethod failed");
		return NULL;
	}else{
		return packageName;
	}
}

jstring JNICALL Java_getDeviceId(JNIEnv* env, jobject context){
    jclass context_class = (*env)->FindClass(env, "android/content/Context");
    jmethodID getSystemService = (*env)->GetMethodID(env, context_class, "getSystemService", "(Ljava/lang/String;)Ljava/lang/Object;");
    jfieldID STATIC_TELEPHONY_SERVICE = (*env)->GetStaticFieldID(env, context_class, "TELEPHONY_SERVICE", "Ljava/lang/String;");
    jstring telephony_service_value = (jstring)(*env)->GetStaticObjectField(env, context_class, STATIC_TELEPHONY_SERVICE);

    jobject telephony_manager_instance = (*env)->CallObjectMethod(env, context, getSystemService, telephony_service_value);
    jclass telephony_manager_class = (*env)->FindClass(env, "android/telephony/TelephonyManager");
    jmethodID getDeviceId = (*env)->GetMethodID(env, telephony_manager_class, "getDeviceId", "()Ljava/lang/String;");
    jstring deviceId = (jstring)(*env)->CallObjectMethod(env, telephony_manager_instance, getDeviceId);
    return deviceId;
}
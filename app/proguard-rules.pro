# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontwarn java.nio.file.Files
-dontwarn java.nio.file.Path
-dontwarn java.nio.file.OpenOption

# Keep NetworkService interface and its methods
-keep interface com.dimas.networkexercise.data.NetworkService { *; }

# Retrofit annotations
-keepattributes *Annotation*
-keepclasseswithmembers class * {
    @retrofit2.* <methods>;
}

# Gson annotations
-keepattributes Signature
-keepattributes *Annotation*
-keepclassmembers class * {
    @com.google.gson.annotations.* <fields>;
}

# Keep the LoginResponseTypeAdapter class and its constructor
-keepclassmembers class com.dimas.networkexercise.base.typeadapter.LoginResponseTypeAdapter {
    <init>(...);
}

# Keep the LoginResponse class
-keep class com.dimas.networkexercise.data.response.LoginResponse { *; }
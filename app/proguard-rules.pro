-keepattributes Signature
-keepattributes InnerClasses

-keep class **.R$* { *; }

-keepclassmembers class * {
    @android.webkit.WebView * <methods>;
}

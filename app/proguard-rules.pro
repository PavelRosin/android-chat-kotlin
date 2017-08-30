-optimizationpasses 5

-dontusemixedcaseclassnames

-dontskipnonpubliclibraryclasses

-verbose

-useuniqueclassmembernames

-keepattributes SourceFile,LineNumberTable

-allowaccessmodification

-keep class **$$ViewInjector { *; }

-keep class **$$ViewBinder { *; }

-dontwarn com.gc.materialdesign.views.**

-dontwarn com.squareup.picasso.**

-dontwarn com.squareup.javapoet.**

-dontwarn com.squareup.okhttp.**

-dontwarn com.google.common.**

-dontwarn com.google.auto.**

-dontwarn okio.**

-dontnote org.joda.**


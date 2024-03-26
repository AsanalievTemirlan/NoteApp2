// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    //SafeArgs
    id("androidx.navigation.safeargs.kotlin") version "2.5.3" apply false
    //Ksp
    id("com.google.devtools.ksp") version "1.9.21-1.0.15" apply false
    //FireBase
    id("com.google.gms.google-services") version "4.4.1" apply false
}
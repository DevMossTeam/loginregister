plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.habiburrohman.bizzhub"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.habiburrohman.bizzhub"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dependencies {
        implementation(libs.appcompat)
        implementation(libs.material)
        implementation(libs.activity)
        implementation(libs.constraintlayout)
        implementation(libs.filament.android)

        testImplementation(libs.junit)
        androidTestImplementation(libs.junit) // Corrected: Make sure this points to the correct library
        androidTestImplementation(libs.espresso.core)
    }
}
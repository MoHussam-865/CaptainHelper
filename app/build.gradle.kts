plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.android_a865.captainhelper"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.android_a865.captainhelper"
        minSdk = 24
        targetSdk = 33
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding {
        enable = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Fragment
    implementation("androidx.fragment:fragment-ktx:1.4.0")

    // Lifecycle + ViewModel & LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")


    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.3")

    // Room
    implementation ("androidx.room:room-runtime:2.4.0")
    implementation("androidx.room:room-compiler:2.4.0")
    implementation ("androidx.room:room-ktx:2.4.0")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")


    // Hilt
    implementation ("com.google.dagger:hilt-android:2.33-beta")
    implementation("com.google.dagger:hilt-android-compiler:2.33-beta")
    // Hilt Jetpack Integrations
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    implementation ("androidx.hilt:hilt-compiler:1.0.0")

    // DataStore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

}
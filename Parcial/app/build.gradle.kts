plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.hidalgo.parcial"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hidalgo.parcial"
        minSdk = 29
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    //Serialization
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    //CORRUTINAS
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // proyecto con la última versión de Android Studio
    implementation("com.github.bumptech.glide:glide:4.16.0")
    //COIL
    implementation("io.coil-kt:coil:2.6.0")
    //Material Design 3
    implementation ("androidx.compose.material3:material3-android:1.2.1")

}
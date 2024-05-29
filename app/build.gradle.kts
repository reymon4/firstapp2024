plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.reymon.myFirstApp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.reymon.myFirstApp"
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
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.activity:activity:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    //Serialization
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    //CORRUTINAS
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    //GLIDE -> Tratar de implementar la nueva implementación de bibliotecas con un
    // proyecto con la última versión de Android Studio
    implementation("com.github.bumptech.glide:glide:4.16.0")
    //COIL
    implementation("io.coil-kt:coil:2.6.0")
    //Material Design 3
    implementation ("androidx.compose.material3:material3-android:1.2.1")

}
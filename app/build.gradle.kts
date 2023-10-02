import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hilt)


}

android {
    namespace = "com.david.cashxchange"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.david.cashxchange"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.identity.credential)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    implementation(libs.hilt.android)
    implementation(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.work)
   implementation(libs.androidx.hilt.compiler)
    implementation(libs.androidx.work.runtime.ktx)
    implementation(libs.androidx.hilt.navigation.compose)


        //Material Spinner
    implementation (libs.material.spinner)


    //Caroutines
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.kotlinx.coroutines.play.services)

    //Retrofit
    //def retrofit_version = "2.9.0"
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.logging.interceptor)
    implementation (libs.converter.scalars)

    //material design
    implementation (libs.material)

    //Glide
    implementation (libs.glide)
    implementation (libs.compiler)

    //Dexter for permission
    implementation (libs.dexter)

    // LifeCycle
    //def lifecycle_version = "2.2.0"

    // ViewModel
    //implementation (libs.androidx.lifecycle.viewmodel.ktx.v220)
    //implementation (libs.androidx.lifecycle.runtime.ktx.v220)


    // LiveData
    implementation (libs.androidx.lifecycle.livedata.ktx)

    //Room
    //def room_version = "2.3.0-alpha02"
    //noinspection GradleDependency
    implementation (libs.androidx.room.runtime)
    implementation (libs.androidx.room.compiler)

    //noinspection GradleDependency
    implementation (libs.androidx.room.ktx)

    //Get currency code
    //implementation (libs.nv.i18n)









}
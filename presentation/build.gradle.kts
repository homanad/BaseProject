plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "com.homanad.android.project.base"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.homanad.android.project.base"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = getInstrumentation()
//        testInstrumentationRunner = "com.homanad.android.project.base.cucumber.runner.CucumberTestRunner"
    }

//    sourceSets["androidTest"].assets {
//        srcDirs("src/androidTest/assets")
//    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            buildConfigField("String", "TEST_TAGS", "\"${getTags()}\"")
            buildConfigField("String", "TEST_SCENARIO", "\"${getTestScenarios()}\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
        buildConfig = true
    }
}

fun getInstrumentation(): String {
    return if (project.hasProperty("cucumber"))
        "com.homanad.android.project.base.cucumber.runner.CucumberTestRunner"
    else "androidx.test.runner.AndroidJUnitRunner"
}

fun getTags(): String {
    return (project.properties["tags"] as? String?) ?: ""
}

fun getTestScenarios(): String {
    return (project.properties["scenario"] as? String?) ?: ""
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.viewmodel)

    testImplementation(libs.junit)
    testImplementation(libs.coroutines.test)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.cucumber.android.test)
//    androidTestImplementation(libs.android.support.test )
    androidTestImplementation(libs.cucumber.picocontainer.test)
}
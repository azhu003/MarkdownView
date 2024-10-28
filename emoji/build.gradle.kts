plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "br.tiagohm.markdownview.emoji"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
//        versionCode = 1
//        versionName = "1.0"
    }
    lint {
        targetSdk = 34
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
}

//noinspection UseTomlInstead
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

//    implementation(libs.androidx.appcompat)
//    testImplementation(libs.junit)

    implementation("androidx.appcompat:appcompat:1.7.0")
    testImplementation("junit:junit:4.13.2")

//    androidTestImplementation 'com.android.support.test:runner:1.0.1'
//    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'
}

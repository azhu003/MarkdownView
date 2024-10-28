plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "br.tiagohm.markdownview.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "br.tiagohm.markdownview.app"
        minSdk = 28
        versionCode = 1
        versionName = "1.0"
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
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)

    implementation(project(":library"))
    implementation(project(":emoji"))
}

plugins {
    alias(libs.plugins.android.library)
}
//apply plugin: 'com.github.dcendents.android-maven'

//group = 'com.github.tiagohm'

android {
    namespace = "br.tiagohm.markdownview"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
//        versionCode = 1
//        versionName = "0.19.0"
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

    implementation("androidx.appcompat:appcompat:1.7.0")
    testImplementation("junit:junit:4.13.2")
    //Flexmark
    implementation("com.vladsch.flexmark:flexmark:0.64.8")
    implementation("com.vladsch.flexmark:flexmark-ext-tables:0.64.8")
    implementation("com.vladsch.flexmark:flexmark-ext-gfm-strikethrough:0.64.8")
    implementation("com.vladsch.flexmark:flexmark-ext-gfm-tasklist:0.64.8")
    implementation("com.vladsch.flexmark:flexmark-ext-autolink:0.64.8")
    implementation("com.vladsch.flexmark:flexmark-ext-abbreviation:0.64.8")
    implementation("com.vladsch.flexmark:flexmark-ext-superscript:0.64.8")
    implementation("com.vladsch.flexmark:flexmark-ext-footnotes:0.64.8")
    implementation("com.vladsch.flexmark:flexmark-ext-attributes:0.64.8")
    //Logger
    implementation("com.orhanobut:logger:1.15")
}

configurations.all {
    resolutionStrategy {
        force("org.jetbrains.kotlin:kotlin-stdlib:1.8.22")
        force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.22")
    }
}